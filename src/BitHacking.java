// file: BitHacking.java
// author: Bob Muller
//
// CSCI 1102 Computer Science 2
//
// Java's bitwise operators: e1 and e2 are expressions of type
// int (i.e., signed 32-bit integers).
//
// AND:   e1 & e2 -- Let v1 be the (32-bit) value of e1 and
//                   let v2 be the value of e2. Then for
//                   k = 0,..,31: bit k is a 1 in the value of
//                   e1 & e2 if and only if bit k is 1 in
//                   BOTH v1 and v2, otherwise it is 0.
//
// OR:    e1 | e2 -- Let v1 be the (32-bit) value of e1 and
//                   let v2 be the value of e2. Then for
//                   k = 0,..,31: bit k is a 1 in the value of
//                   e1 | e2 if and only if bit k is 1 in
//                   EITHER v1 and v2, otherwise it is 0.
//
// NOT:   ~e1     -- Let v be the (32-bit) value of e1. Then for
//                   k = 0,..,31: bit k is a 1 in ~e1 if and only
//                   if bit k is 0 in v, otherwise it is 0.
//
// SHIFT LEFT:
//      e1 << e2  -- Let v1 be the (32-bit) value of e1 and
//                   let v2 be the value of e2. Then the value
//                   of e1 << e2 is v1 shifted v2 bits to the
//                   left, NB: not preserving the sign bit.
// SHIFT RIGHT:
//      e1 >> e2  -- Like shift left. Sign extension.

public class BitHacking {

  public static int twosComplement(int n) {
    return ~n + 1;
  }

  public static void main(String[] args) {

    // Demonstrate Hexadecimal
    //
    int a = 188;
    System.out.format("Demo hex: a = %d, a = 0x%08x%n", a, a);

    // Demonstrate Twos Complement
    //
    int b1 = 0x1A,
        b2 = -b1;
    String
      fmt = "Demo twos comp: b1 = %d, b1 = 0x%08x, -b1 = %d, -b1 = 0x%08x%n";
    System.out.format(fmt, b1, b1, b2, b2);

    // Demonstrate AND
    //
    int mask = 0x0F0,
        c1 = 0xABC,
        c2 = c1 & mask;
    String fmtAND = "Demo AND: c1 = 0x%08x, c1 & 0x0F0 = 0x%08x%n";
    System.out.format(fmtAND, c1, c2);

    // Demonstrate OR
    //
    int //mask = 0x0F0,
        d1 = 0xABC,
        d2 = d1 | mask;
    String fmtOR = "Demo OR:  d1 = 0x%08x, d1 | 0x0F0 = 0x%08x%n";
    System.out.format(fmtOR, d1, d2);

    // Demonstrate NOT
    //
    int e1 = 0xABC;
    System.out.format("Demo NOT:  e1 = 0x%08x, ~e1 = 0x%08x%n", e1, ~e1);

    // Demonstrate SHIFT RIGHT, NB: Sign Extension!
    //
    int f1 = 0xF0000000,
        f2 = 2;
    String
      fmtSR = "Demo SHFT RIGHT:  f1 = 0x%08x, f2 = %d, f1 >> f2 = 0x%08x%n";
    System.out.format(fmtSR, f1, f2, f1 >> f2);

    // Demonstrate SHIFT LEFT, NB: Sign bit can change!
    //
    int g1 = 0x70000000,
        g2 = 2;
    String
      fmtSL = "Demo SHFT LEFT:  g1 = 0x%08x, g2 = %d, g1 << g2 = 0x%08x%n";
    System.out.format(fmtSL, g1, g2, g1 << g2);

    // Demonstrate TWO's COMPLEMENT.
    //
    System.out.println("Demo Two's Compl:");
    for(byte i=-5; i<5; i++)
      System.out.format("i = %d, = 0x%02x%n", i, i);
  }
}
