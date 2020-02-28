package sk.tuke.rusyn.ink;

import android.app.Application;

import sk.tuke.rusyn.ink.certificate.MyCertificate;
import com.myscript.iink.Engine;

public class IInkApplication extends Application
{
  private static Engine engine;

  public static synchronized Engine getEngine()
  {
    if (engine == null)
    {
      engine = Engine.create(MyCertificate.getBytes());
    }

    return engine;
  }

}
