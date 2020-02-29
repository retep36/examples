package sk.tuke.rusyn.ink.certificate;

/**
 * The <code>MyCertificate</code> class provides the bytes of the user
 * certificate used to grant the access to the MyScript technologies.
 */
public final class MyCertificate
{
  /**
   * Returns the bytes of the user certificate.
   *
   * @return The bytes of the user certificate.
   */
  public static final byte[] getBytes()
  {
    return BYTES;
  }

  /**
   * The bytes of the user certificate.
   */
  private static final byte[] BYTES = new byte[]{
    30,   -85,  -7,   -79,  -41,  41,   35,   -110, 
    -67,  -64,  79,   115,  3,    87,   120,  82,   
    49,   124,  -31,  14,   56,   41,   77,   9,    
    24,   103,  -2,   17,   32,   -10,  92,   14,   
    56,   -3,   -118, 99,   76,   -14,  -14,  78,   
    2,    -14,  56,   -2,   -20,  89,   -49,  -126, 
    -97,  -117, 68,   -94,  -49,  -81,  94,   39,   
    -108, -55,  18,   -107, -124, -120, -60,  -65,  
    -99,  -94,  118,  -29,  -54,  -15,  -115, -25,  
    120,  -13,  75,   126,  -92,  -63,  92,   -111, 
    44,   -90,  89,   123,  -62,  -96,  106,  22,   
    -77,  -101, -54,  -31,  111,  -8,   -67,  -50,  
    -103, -119, -86,  -103, -68,  11,   105,  -109, 
    101,  -125, 83,   -89,  -44,  -110, -26,  -16,  
    -107, 22,   -72,  -89,  -9,   116,  -89,  71,   
    92,   32,   73,   3,    83,   -122, 85,   -75,  
    -76,  -55,  77,   41,   96,   -58,  44,   -94,  
    -75,  -76,  -35,  20,   79,   92,   11,   9,    
    110,  79,   -12,  -3,   61,   25,   22,   -13,  
    -65,  -52,  -79,  17,   12,   -28,  -128, 123,  
    102,  -85,  118,  -95,  112,  -68,  47,   -20,  
    62,   -122, 27,   -103, 36,   31,   117,  -44,  
    7,    -46,  89,   89,   9,    -85,  4,    108,  
    -48,  -37,  -41,  123,  66,   43,   -107, -47,  
    26,   63,   4,    -58,  -114, 26,   -62,  -101, 
    -10,  66,   51,   -4,   102,  9,    106,  -2,   
    -8,   99,   113,  115,  -32,  -49,  105,  120,  
    -48,  12,   97,   83,   100,  44,   -64,  -45,  
    52,   0,    -87,  78,   66,   10,   32,   26,   
    -93,  -12,  -90,  110,  11,   27,   -19,  -1,   
    127,  -102, -5,   -74,  61,   -51,  -77,  -35,  
    7,    77,   -106, -24,  112,  -30,  -104, 101,  
    34,   -89,  109,  30,   -82,  72,   28,   65,   
    124,  83,   -42,  86,   -102, -76,  55,   -126, 
    125,  -91,  111,  30,   68,   18,   -117, 66,   
    -80,  40,   69,   85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -101, -76,  55,   -126, 
    39,   70,   -78,  28,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  68,   18,   -117, 66,   
    -64,  21,   101,  87,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -101, -76,  55,   -126, 
    -9,   -39,  90,   27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  68,   18,   -117, 66,   
    -6,   -70,  -103, 84,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -101, -76,  55,   -126, 
    -107, -28,  -47,  27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  68,   18,   -117, 66,   
    96,   -120, 70,   82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -101, -76,  55,   -126, 
    18,   41,   -26,  31,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  71,   18,   -117, 66,   
    125,  32,   18,   83,   94,   -70,  55,   -126, 
    33,   -91,  111,  30,   -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -104, -76,  55,   -126, 
    70,   -97,  107,  28,   -125, 28,   -117, 66,   
    120,  -34,  -15,  86,   101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  71,   18,   -117, 66,   
    -100, -34,  5,    85,   80,   -70,  55,   -126, 
    38,   -91,  111,  30,   -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -104, -76,  55,   -126, 
    41,   61,   -116, 28,   -118, 28,   -117, 66,   
    120,  -34,  -15,  86,   101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  71,   18,   -117, 66,   
    39,   -119, -112, 87,   73,   -70,  55,   -126, 
    42,   -91,  111,  30,   -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -104, -76,  55,   -126, 
    -13,  -109, -39,  29,   -103, 28,   -117, 66,   
    118,  -34,  -15,  86,   101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  71,   18,   -117, 66,   
    4,    108,  39,   82,   124,  -70,  55,   -126, 
    43,   -91,  111,  30,   -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -104, -76,  55,   -126, 
    -67,  -43,  104,  31,   -85,  28,   -117, 66,   
    123,  -34,  -15,  86,   101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  71,   18,   -117, 66,   
    101,  -99,  -65,  87,   73,   -70,  55,   -126, 
    32,   -91,  111,  30,   -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -104, -76,  55,   -126, 
    -101, -47,  19,   27,   -80,  28,   -117, 66,   
    116,  -34,  -15,  86,   101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  65,   18,   -117, 66,   
    33,   -119, 4,    82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -98,  -76,  55,   -126, 
    -55,  8,    -96,  29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  65,   18,   -117, 66,   
    -87,  -15,  -80,  85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -98,  -76,  55,   -126, 
    111,  78,   114,  29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    102,  -99,  41,   82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    74,   0,    28,   31,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    113,  -38,  5,    85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    92,   -128, -55,  28,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    94,   -68,  -110, 82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -88,  38,   -41,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    87,   -57,  23,   86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    117,  118,  -104, 30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    58,   -44,  -40,  87,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -111, 51,   66,   31,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    20,   -44,  120,  87,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    3,    66,   -99,  31,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -2,   -49,  9,    87,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    107,  20,   95,   28,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -12,  119,  -61,  84,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    124,  126,  51,   28,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -115, -76,  -82,  84,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    26,   59,   -61,  28,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    78,   8,    45,   84,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    7,    -72,  110,  29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    48,   -47,  -111, 85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -31,  21,   10,   29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -43,  54,   -105, 85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -117, -1,   2,    29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -113, -110, 116,  85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    36,   10,   -59,  29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    105,  52,   92,   85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    51,   72,   -42,  29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -114, -74,  48,   85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    31,   110,  -119, 29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    51,   88,   25,   85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -101, 75,   -112, 29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -121, -28,  -14,  82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -81,  72,   102,  26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    6,    -89,  -90,  82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    29,   -88,  54,   26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -52,  76,   -114, 82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -116, 16,   -5,   26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -27,  -99,  102,  82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -58,  34,   -10,  26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -3,   29,   89,   82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    75,   9,    -35,  26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    53,   125,  57,   82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -6,   -19,  -75,  26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    79,   35,   46,   82,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    60,   -101, -101, 26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    55,   -39,  -13,  83,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    82,   -94,  100,  27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -53,  29,   -4,   83,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    24,   32,   90,   27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    13,   57,   -87,  83,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -123, 67,   53,   27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -25,  67,   -103, 83,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -22,  -15,  2,    27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    41,   127,  -126, 83,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -72,  -47,  27,   27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -113, -63,  124,  83,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -10,  -29,  -4,   27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -1,   9,    79,   83,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    83,   2,    -70,  27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    13,   -120, 9,    84,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    62,   26,   81,   29,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -3,   79,   64,   86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    80,   54,   93,   27,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -64,  -107, -83,  85,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -110, 127,  7,    28,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -115, 62,   85,   84,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    32,   109,  101,  26,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  70,   18,   -117, 66,   
    -103, -105, -126, 87,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    103,  -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -103, -76,  55,   -126, 
    -30,  88,   -76,  31,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    56,   -91,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  64,   18,   -117, 66,   
    124,  -34,  -15,  86,   103,  -70,  55,   -126, 
    17,   -92,  111,  30,   -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  -100, -76,  55,   -126, 
    -36,  90,   -112, -31,  106,  2,    -117, 66,   
    76,   -34,  -15,  86,   101,  75,   -56,  125,  
    -36,  90,   -112, -31,  -70,  -19,  116,  -67,  
    -125, 33,   14,   -87,  101,  75,   -56,  125,  
    -36,  90,   -112, -31,  119,  86,   -58,  35,   
    8,    -74,  -94,  62,   -5,   -60,  82,   -42,  
    70,   -35,  27,   87,   43,   121,  -40,  39,   
    29,   -84,  -110, 62,   -54,  -58,  82,   -26,  
    74,   -58,  27,   119,  42,   124,  -49,  45,   
    31,   -85,  -100, 51,   -12,  -64,  112,  -25,  
    80,   -47,  26,   108,  32,   83,   -27,  35,   
    16,   -89,  -117, 51,   -24,  -18,  -2,   -71,  
    46,   -14,  -82,  -17,  69,   54,   -39,  93,   
    51,   -18,  115,  87,   -72,  -124, 58,   -124, 
    42,   -113, -23,  86,   -61,  -27,  -122, 67,   
    125,  -33,  -12,  86,   -103, 54,   54,   -115, 
    35,   -107, -19,  31,   79,   16,   9,    67,   
    125,  -34,  32,   68,   -28,  -79,  -78,  44,   
    -68,  -30,  -58,  -24,  15,   82,   56,   85,   
    -75,  112,  -9,   47,   -42,  42,   -122, -127, 
    -67,  9,    42,   60,   76,   -32,  67,   121,  
    -19,  -37,  -64,  -47,  20,   31,   -25,  44,   
    72,   -102, 77,   -20,  92,   -94,  -125, 7,    
    -29,  88,   43,   13,   27,   -117, -110, -82,  
    -126, 101,  39,   98,   19,   121,  73,   -103, 
    -97,  80,   -83,  0,    16,   113,  68,   42,   
    102,  -63,  -26,  -78,  111,  4,    54,   127,  
    -40,  -104, 105,  -7,   -92,  118,  2,    26,   
    57,   -69,  96,   -72,  -26,  -58,  92,   116,  
    11,   -80,  38,   -70,  -19,  -126, 94,   -60,  
    29,   -88,  -26,  -80,  -52,  -45,  -126, 22,   
    33,   -21,  -1,   -44,  -24,  -72,  -106, 112,  
    -53,  -115, 27,   -36,  -19,  105,  -9,   -100, 
    -122, 106,  -109, 97,   119,  -63,  118,  -87,  
    -93,  66,   61,   -80,  -55,  -51,  -110, 69,   
    -92,  72,   21,   45,   -60,  12,   83,   -37,  
    50,   -113, 68,   -27,  -28,  -107, 101,  108,  
    59,   -78,  -106, 68,   -126, 24,   0,    67,   
    -51,  -40,  88,   51,   18,   18,   -85,  -102, 
    16,   -51,  -101, 96,   -42,  -88,  -80,  45,   
    -72,  -88,  -16,  55,   17,   -76,  -79,  -128, 
    24,   125,  113,  -73,  71,   113,  -34,  105,  
    -99,  -31,  67,   -38,  115,  -1,   -1,   26,   
    56,   104,  20,   12,   -63,  37,   111,  -53,  
    10,   0,    -75,  73,   -116, -81,  -111, -16,  
    95,   59,   74,   28,   -109, 48,   55,   86,   
    12,   38,   -16,  -43,  -49,  55,   102,  -4,   
    69,   100,  111,  117,  69,   20,   -69,  88,   
    -38,  -88,  50,   -96,  116,  11,   68,   -85,  
    35,   25,   -13,  85,   -101, -76,  54,   -22,  
    87,   -47,  31,   109,  127,  61,   -92,  35,   
    8,    -75,  -33,  59,   -29,  -57,  84,   -16,  
    74,   -43,  27,   48,   38,   125,  -26,  109,  
    24,   -69,  -121, 63,   -7,   -47,  8,    -29,  
    83,   -43,  38,   90,   120,  55,   -8,   100,  
    24,   -65,  -123, 55,   -89,  -111, 68    
  };

} // end of: class MyCertificate