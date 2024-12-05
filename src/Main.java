
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.LinkedList;

public class Main {

    private static final int LENGTH = 2048;


    public Main() {
        // для возможности использования переменной random
        SecureRandom random = new SecureRandom();
        // генерация большого простого числа
//        BigInteger p = BigInteger.probablePrime(LENGTH / 2, random);
//        BigInteger q = BigInteger.probablePrime(LENGTH / 2, random);
        BigInteger p = new BigInteger("3");
        BigInteger q = new BigInteger("11");
        // умножение p и q
        BigInteger n = p.multiply(q);
        System.out.println(n);
        // вычисление функцции Эйлера
        BigInteger euler = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        System.out.println(euler);
        // генерация e
        BigInteger e = new BigInteger("7");
        System.out.println(e);
        BigInteger d = e.modInverse(euler);
        System.out.println(d);
        // зашифровываем сообщение
        BigInteger m = new BigInteger("312");
        LinkedList<BigInteger> input = new LinkedList<>();
        while (m.compareTo(new BigInteger("0")) > 0)
        {
            input.addFirst(m.remainder(new BigInteger("10")).modPow(e, n) );
            m = m.divide(new BigInteger("10"));
        }
        System.out.println(input);
        for (int i = 0; i < input.size(); i++)
        {
            input.set(i, input.get(i).modPow(d, n));
        }
        System.out.println(input);

    }

    public static void main(String[] args) {
        new Main();
    }
}
