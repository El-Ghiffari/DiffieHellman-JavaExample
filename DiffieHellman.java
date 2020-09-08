import java.util.Scanner;

public class DiffieHellman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner input = new Scanner(System.in);
	    	    
	    System.out.println("Masukan bilangan prima p : ");
	    long bilangan_prima_p = input.nextLong();
	     
	    System.out.println("Masukan bilangan shared secret : ");
	    long bilangan_a = input.nextLong();

	    System.out.println("Masukan private key anda: ");
	    long bilangan_k = input.nextLong();
	    
	    long kode_publik = (long)Math.pow(bilangan_a, bilangan_k)% bilangan_prima_p ;
	    
	    System.out.println("Berikut ini adalah public key yang dikirimkan kepada pasangan bicara: " + kode_publik);
	    
	    System.out.println("Masukan public key yang anda terima dari pasangan bicara: ");
	    long kode_publik_pasangan = input.nextLong();

	    long shared_key_rahasia = getSharedKeyDiffieHellman(bilangan_prima_p, bilangan_a, bilangan_k, kode_publik_pasangan);

	    System.out.print("Tuliskan pesan yang akan dikirim: ");
	    String pesan_asli = input.next();
	    
	    String pesan_rahasia = cipher(pesan_asli,shared_key_rahasia);
	    
	    System.out.println("Pesan setelah di enkripsi: " + pesan_rahasia );    
	}


	static long getSharedKeyDiffieHellman(long bilangan_prima_p, long bilangan_a, long bilangan_k, long kode_publik_pasangan){
		return (long) Math.pow(kode_publik_pasangan, bilangan_k)%bilangan_prima_p;
		
	}

	static String cipher(String msg, long shift){
	    String s = "";
	    int len = msg.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(msg.charAt(x) + (shift+x));
	        if (c > 'z')
	            s += (char)(msg.charAt(x) - (26-shift-x));
	        else if(c < 'a'){
	        	s += (char)(msg.charAt(x) + (26+shift+x));	        	
	        }
	        else
	            s += (char)(msg.charAt(x) + (shift+x));
	    }
	    return s;
    }
    
}
