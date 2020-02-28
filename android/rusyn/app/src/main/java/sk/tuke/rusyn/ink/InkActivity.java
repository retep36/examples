package sk.tuke.rusyn.ink;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.myscript.iink.Configuration;
import com.myscript.iink.ContentBlock;
import com.myscript.iink.ContentPackage;
import com.myscript.iink.ContentPart;
import com.myscript.iink.Editor;
import com.myscript.iink.Engine;
import com.myscript.iink.IEditorListener;
import com.myscript.iink.MimeType;
import com.myscript.iink.uireferenceimplementation.EditorView;
import com.myscript.iink.uireferenceimplementation.InputController;

import java.io.File;
import java.io.IOException;
import java.util.List;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.entities.Answer;
import sk.tuke.rusyn.helpers.DatabaseHelper;
import sk.tuke.rusyn.questions.Question;
import sk.tuke.rusyn.questions.SumActivity;
import sk.tuke.rusyn.screens.ListOfLessons;
import sk.tuke.rusyn.screens.Score;

public class InkActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private Engine engine;
    private ContentPackage contentPackage;
    private ContentPart contentPart;
    private EditorView editorView;
    private int score,questionCounter;
    private String odpoved;
    private ContentBlock contentBlock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ErrorActivity.installHandler(this);
        engine = IInkApplication.getEngine();

        // configure recognition
        Configuration conf = engine.getConfiguration();
        String confDir = "zip://" + getPackageCodePath() + "!/assets/conf";
        conf.setStringArray("configuration-manager.search-path", new String[] { confDir });
        String tempDir = getFilesDir().getPath() + File.separator + "tmp";
        conf.setString("content-package.temp-folder", tempDir);

        setContentView(R.layout.activity_ink);
        editorView = findViewById(R.id.editor_view);
        editorView.setEngine(engine);

        final Editor editor = editorView.getEditor();
        editor.addListener(new IEditorListener() {
            @Override
            public void partChanging(Editor editor, ContentPart oldPart, ContentPart newPart) {
                // no-op
            }

            @Override
            public void partChanged(Editor editor) {
                invalidateOptionsMenu();
                invalidateIconButtons();
            }

            @Override
            public void contentChanged(Editor editor, String[] blockIds) {
                invalidateOptionsMenu();
                invalidateIconButtons();
            }

            @Override
            public void onError(Editor editor, String blockId, String message) {
                Log.e(TAG, "Failed to edit block \"" + blockId + "\"" + message);
            }
        });

        editorView.setInputController(new InputController(this, editorView));
        setInputMode(InputController.INPUT_MODE_FORCE_PEN);

        questionCounter = (int) getIntent().getExtras().get("questionPosition");
        score = (int) getIntent().getExtras().get("score");
        String packageName = String.format("File1%d.iink",questionCounter);
        File file = new File(getFilesDir(), packageName);
        try {
            contentPackage = engine.createPackage(file);
            contentPart = contentPackage.createPart("Text Document");
        }
        catch (IOException e) {
            Log.e(TAG, "Failed to open package \"" + packageName + "\"", e);
        }
        catch (IllegalArgumentException e) {
            Log.e(TAG, "Failed to open package \"" + packageName + "\"", e);
        }

        String otazka = String.valueOf(getIntent().getExtras().get("value"));
        setTitle("Prelož: " + otazka);

        // wait for view size initialization before setting part
        editorView.post(new Runnable() {
            @Override
            public void run() {
                editorView.getRenderer().setViewOffset(0, 0);
                editorView.getRenderer().setViewScale(1);
                editorView.setVisibility(View.VISIBLE);
                editor.setPart(contentPart);
            }
        });

        findViewById(R.id.button_undo).setOnClickListener(this);
        findViewById(R.id.button_redo).setOnClickListener(this);
        findViewById(R.id.button_clear).setOnClickListener(this);
        invalidateIconButtons();
    }

    @Override
    protected void onDestroy() {
        editorView.setOnTouchListener(null);
        editorView.close();

        if (contentPart != null) {
            contentPart.close();
            contentPart = null;
        }
        if (contentPackage != null) {
            contentPackage.close();
            contentPackage = null;
        }
        // IInkApplication has the ownership, do not close here
        engine = null;
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ink, menu);

        MenuItem convertMenuItem = menu.findItem(R.id.menu_convert);
        convertMenuItem.setEnabled(true);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_convert: {
                Editor editor = editorView.getEditor();
                editor.convert(null, editor.getSupportedTargetConversionStates(null)[0]);

                try {
                    DatabaseHelper databaseHelper = new DatabaseHelper(this);
                    List<Answer> answerList = databaseHelper.getAnswersList(questionCounter-1);
                    odpoved = String.valueOf(databaseHelper.getCorrectAnswer(questionCounter-1).getAnswers()); //
                    if( answerList.get(0).getAnswers().equals(editor.export_( editor.getRootBlock(), MimeType.TEXT).toUpperCase())){
                        contentPackage.close();
                        System.out.println(answerList.get(0).getAnswers() + "  " + editor.export_( editor.getRootBlock(), MimeType.TEXT).toUpperCase());
                        Intent intent = new Intent(getBaseContext(), SumActivity.class);
                        intent.putExtra("spravne",1);
                        intent.putExtra("nespravne",0);
                        intent.putExtra("odpoved", odpoved);//
                        intent.putExtra("score", score+1);
                        intent.putExtra("questionPosition", questionCounter );
                        startActivity(intent);
                    } else {
                        contentPackage.close();
                        System.out.println(answerList.get(0).getAnswers() + "  " + editor.export_( editor.getRootBlock(), MimeType.TEXT).toUpperCase());
                        Intent intent = new Intent(getBaseContext(), SumActivity.class);
                        intent.putExtra("spravne",0);
                        intent.putExtra("nespravne",1);
                        intent.putExtra("odpoved", odpoved);//
                        intent.putExtra("score", score);
                        intent.putExtra("questionPosition", questionCounter );
                        startActivity(intent);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_undo:
                editorView.getEditor().undo();
                break;
            case R.id.button_redo:
                editorView.getEditor().redo();
                break;
//            case R.id.button_clear:
//                editorView.getEditor().clear();
//                break;
            default:
                break;
        }
    }

    private void setInputMode(int inputMode) {
        editorView.setInputMode(inputMode);
    }

    private void invalidateIconButtons() {
        Editor editor = editorView.getEditor();
        final boolean canUndo = editor.canUndo();
        final boolean canRedo = editor.canRedo();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ImageButton imageButtonUndo = (ImageButton)findViewById(R.id.button_undo);
                imageButtonUndo.setEnabled(canUndo);
                ImageButton imageButtonRedo = (ImageButton)findViewById(R.id.button_redo);
                imageButtonRedo.setEnabled(canRedo);
//                ImageButton imageButtonClear = (ImageButton)findViewById(R.id.button_clear);
//                imageButtonClear.setEnabled(contentPart != null);
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {
        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Chcete ukončiť lekciu?")
                .setPositiveButton("Áno", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(InkActivity.this, ListOfLessons.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }
}
