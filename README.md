# CSCI 1102 Computer Science 2

### Fall 2018

------

## Lecture Notes

### Week 9: Shannon Week

#### Topics:

1. Overview of Shannon's n-gram algorithm (PS6)
2. Overview of Huffman's Coding algorithm (PS7 & PS8)
3. Working with bits in Java

---

## 1. Overview of Shannon's n-gram algorithm

See the write-up for problem set 6.

## 2. Overview of Huffman's Coding algorithm

See the write-ups for problem sets 7 and 8.

## 3. Working with bits in Java

Most high-level programming languages provide some operators that allow the programmer to work directly with bits. Usually the bits reside in a value of one of the integers types, in Java this would be `byte`, `short`, `int` or `long`. See the file `BitHacking.java` in the `src` folder for examples.

Remember the set $\mathrm{Bits} = \{0, 1\}$, and that bit strings of length $k$ are
$$
\mathrm{Bits}^k = \{ w \mid w\in \mathrm{Bits}^*\ \mathrm{with}\
  \mid\! w \!\mid\; = k \}
$$
and since there are 2 bits, the size of the set $\mathrm{Bits}^k$ is $2^k$.

##### Example

if we're interested in representing the four nucleotides *adenine*, *cytosine*, *guanine* and *thymine*, we could choose $n = 2$ because $2^2 = 4$ and we'd have exactly one 2-bit pattern for each nucleotide. We might choose, say

| adenine | cytosine | guanine | thymine |
| :-----: | :------: | :-----: | :-----: |
|   00    |    01    |   10    |   11    |

##### Example

If we wanted to represent the 26 uppercase letters in the Roman alphabet, **A** through **Z**, we'd need bit sequences of length $n = 5$ because $2^5 = 32$. This enables us to choose a unique sequence for each letter (with 6 left over). Choosing $n = 4$ wouldn't do because $2^4 = 16$ — too few patterns to have unique representations.

### Basic Bitwise Operators

In Java, the operators`~`, `|` and `&` implement simple bit-wise computations.
+ Let `v` be the value of integer expression `e`. Then the *complement* operator `~e` flips all bits in `v`;

+ Let `v1` be the value of integer expression `e1` and let `v2` be the value of integer `e2`, then the *bit-wise or* operator `e1 | e2` turns on bits in the result if they are on in either `v1` or `v2`;
+ Let `v1` be the value of integer expression `e1` and let `v2` be the value of integer expression `e2`, then the *bit-wise and* operator `e1 & e2` turns on bits in the result if they are on in both `v1` and `v2`.

See the examples in `src/BitHacking.java`. **NB: that the bit-wise operators | and & are different that the logical operators || and &&.**

### Positional Numeral systems

A positional numeral system is a symbolic system for representing numbers with sequences of digit symbols. For example, the decimal numeral $2026_{10}$ is a sequence of 4 digits drawn from the familiar set of ten Hindu digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9.

The positional numeral system, what is sometimes referred to as the *Arabic* or *Hindu-Arabic numeral system*, has [a long and interesting history](https://www.nytimes.com/2017/10/07/opinion/sunday/who-invented-zero.html?action=click&pgtype=Homepage&clickSource=story-heading&module=opinion-c-col-right-region&region=opinion-c-col-right-region&WT.nav=opinion-c-col-right-region&_r=0). It has been discovered more than once in various cultures throughout the world, notably by the Sumerians who developed a precursor system more than 4000 years ago using base 60. Fully developed positional numeral systems would not be introduced to the west until the 13th century. This was done in a book *Liber Abaci* (The Book of Calculation) by the Italian mathematician, [Leonardo Bonacci](https://en.wikipedia.org/wiki/Fibonacci) aka Fibonacci, who's principal contribution to mathematics was to recognize the power of the system then used in the Arab world. The positional numeral system was introduced in the Arab world in the 9th century by the Persian mathematician *al*-*Khwārizmī*, after whom the world *algorithm* is named.  *al*-*Khwārizmī* learned the system from Hindu astronomical texts written two centuries before in present-day Pakistan.

#### Interpreting Positional Numerals

The meaning of each occurrence of a digit in a numeral is determined by its position relative to the right end of the numeral, hence the *positional*. In 2026, the leftmost occurrence of the digit 2, denotes the number 2000 or $2\times 10^3$. The occurrence of the digit 2 adjacent to the digit 6 denotes the number 20 or $2\times 10^1$ and the digit 6 denotes the number 6 or $6\times 10^0$. The number denoted by the complete numeral is the sum of the values of each of the digits.

$$2026 = 2 \times 10^3 + 0 \times 10^2 + 2 \times 10^1 + 6 \times 10 ^0 = 2000 + 0 + 20 + 6$$

Each digit is the co-efficient of the base raised to the power of the position relative to the right edge of the sequence. The meaning of the numeral is the sum of these products.

The basic positional numeral system described above accounts only for the *natural numbers* — the non-negative integers. To account for negative integers or real numbers requires additional work, we'll touch on it below.

---
#### Alternative Bases

In positional systems, numerals are sequences of digits drawn from a fixed set of digit symbols that are determined by the numeral's *base*. The flexibility of the system with respect to bases seems to have been first noted by  [Gottfried Leibniz](https://en.wikipedia.org/wiki/Gottfried_Wilhelm_Leibniz) who introduced the modern binary numeral system in 1679. We'll explore the binary system in the next section.

As we noted above, for base 10 or *decimal* numerals, we use the familiar set of ten Hindu digits: 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9. The fact that the sequence of digits 2026 is a base 10 numeral is implicit. The base can be signaled explicitly by annotating the digit sequence with the base as a subscript as in $2026_{10}$. For base 5, say, we use the five digits 0, 1, 2, 3 and 4. For base 2 or *binary* we use only two digits 0 and 1 and for base 16 — *hexadecimal* — we use the standard ten decimal digits together with the first six letters of the alphabet A, B, C, D, E and F.

------

## 1. Binary

The flexibility of the positional numeral system with respect to bases seems to have been first noted by Gottfried Leibniz in the late 17th century. Leibniz showed that the basic arithmetic algorithms used for decimal numerals also work when the constant base 10 has been replaced by another base.

Leibniz was particularly interested in the binary numeral system which he introduced in a publication in 1679. His notebooks contain many examples of binary computations.

![LeibnizBinary](/Users/muller/teaching/cs1102/f18/dev/notes/09/img/LeibnizBinary.png)

> Leibniz was also interested in automating computation and designed a machine, the [Stepped Reckoner](), which could perform addition, subtraction, multiplication and division of decimal numerals. In addition to his many other skills, Leibniz was an enthusiastic marketer of his computer:
>
> “It is unworthy of excellent men to lose hours like slaves in the labour of calculation which could safely be relegated to anyone else if machines were used."
>
> — Leibniz in 1685, describing the value to astronomers of the hand-cranked calculating machine he had invented in 1673.
>
> Leibniz' design for the Stepped Reckoner used an intricate system of rotating gears, but the technical requirements were hard to meet in the technology of the day so the stepped-reckoner wasn't functional until centuries later.

### 2. Sibling Bases that are Powers of 2 — Binary and Hexadecimal

We've seen how to use strings of bits to represent alphabetic symbols and non-negative integers. It turns out that we can use bits to represent pretty much anything that we'd like to represent in a computer: documents, songs, pictures, videos, you name it.  But understanding strings of bits quickly gets out of hand, there are just too many of them!

We can abbreviate strings of bits using base 16 or **hexadecimal** or just **hex** notation.  Base 10 numerals are strings of digits drawn from the familiar set of 10 decimal digits (i.e., {0, 1, ..., 9}) and base 2 numerals are drawn from the set of 2 binary digits {0, 1}. Base 16 numerals are strings of 16 hexadecimal digits. What are they? Well it seems reasonable to use the decimal digits 0 through 9 for the first 10 hex digits, then we'll use the first 6 letters of the alphabet A, B, C, D, E and F. In particular, A denotes 10, B denotes 11 etc.

---

Let's take $k = 4$, there are $2^4 = 16$ unique bit strings in $\mathrm{Bits}^4$.

|  |  |  |  |  |  |  |  |
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
| 0000 | 0001 | 0010 | 0011 | 0100 | 0101 | 0110 | 0111 |
| 1000 | 1001 | 1010 | 1011 | 1100 | 1101 | 1110 | 1111 |

Of course we can interpret a string of binary digits as a *numeral* denoting a *natural number* just as we interpret a string of decimal digits. The meaning of each digit is determined by its position relative to the right end of the string. For example, $1101_2$ is 13 because
$$
1 \times 2^3 + 1 \times 2^2 + 0 \times 2^1 + 1 \times 2^0 = 8 + 4 + 0 + 1 = 13
$$

### Hexadecimal as an Abbreviation System

We're often dealing with long strings of bits, usually 8 or 32 bits but sometimes 16 or even 64. (all powers of 2!) So it's convenient to abbreviate the bit strings with hexadecimal (hex) numerals. In particular, 4 bits can be represented by 1 hex digit as shown in the following table.

| binary | decimal | hex | binary | decimal | hex |
| :-----: | :------: | :-----: | :-----: | :-----: | :------: |
|   0000    |    0    |   0    |   1000    | 8 | 8 |   |   |   |   |   |   |
|   0001    |    1    |   1    |   1001    | 9 | 9 |
|   0010    |    2    |   2    |   1010    | 10 | A |
|   0011    |    3    |   3    |   1011    | 11 | B |
|   0100    |    4    |   4    |   1100    | 12 | C |
|   0101    |    5    |   5    |   1101    | 13 | D |
|   0110    |    6    |   6    |   1110    | 14 | E |
|   0111    |    7    |   7    |   1111    | 15 | F |

In particular, note that the 8 bits in a byte can be represented by a pair of hex digits. For example we would abbreviate the byte $1011\;1110_2$ as $BE_{16}$.

#### Shifting Digits by Multiplication or Division

In the positional numeral system, numerals in base $k​$ can be shifted to the left or right by multiplying or dividing by powers of $k​$. For example, decimal numeral $52_{10} * 10^2 = 5200​$. A binary numeral $n​$ can be shifted left $k​$ bits by multiplying by $2^k​$. For example, with $n = 5 = 0101_2​$, $5 * 2^1 = 10_{10} = 1010_2​$.
The corresponding shift right occurs with division.

### Representing Negative Integers

The positional numeral system doesn't provide a direct representation for negative numerals. In binary, we use the leftmost bit as a sign bit. When the sign bit is 1, the numeral denotes a negative integer. When the sign bit is 0, the numeral denotes a non-negative integer.

### Two's complement

Let $n$ be a numeral representing an integer. To find $-n$, flip all the bits and add 1. For example, $5 = 0101_2$, so to find $-5$, we flip all bits, giving $1010_2$ and we add 1 giving $1011_2$. So the string of bits $1011_2$ denotes the number $11_{10}$ when interpreted as an unsigned numeral and it means $-5$ when interpreted as a signed integer.

| binary | decimal | hex | binary | decimal | hex |
| :-----: | :------: | :-----: | :-----: | :-----: | :------: |
|   0000    |    0    |   0    |   1000    | -8 | 8 |   |   |   |   |   |   |
|   0001    |    1    |   1    |   1001    | -7 | 9 |
|   0010    |    2    |   2    |   1010    | -6 | A |
|   0011    |    3    |   3    |   1011    | -5 | B |
|   0100    |    4    |   4    |   1100    | -4 | C |
|   0101    |    5    |   5    |   1101    | -3 | D |
|   0110    |    6    |   6    |   1110    | -2 | E |
|   0111    |    7    |   7    |   1111    | -1 | F |

### Signed Shifting

Java has two operators for performing shifts of signed integers.
+ Let `v1` be the value of `e1` and let `v2` be the value of `e2`, then the *signed shift-left* operator `e1 << e2` produces an integer like `v1` but shifted `v2` positions to the left. Note that 0's fill the open positions on the right;

+ Let `v1` be the value of `e1` and let `v2` be the value of `e2`, then the *signed shift-right* operator `e1 >> e2` produces an integer like `v1` but shifted `v2` positions to the right. Note that the sign bit (whatever it is!) fills in the open positions on the left.
