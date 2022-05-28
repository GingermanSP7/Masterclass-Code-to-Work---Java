package Lezione2.Prove;

public class Equals_hashCode {
    public static void main(String[] args) {
        Customer max1 = new Customer( "max", "123456789" );
        Customer max2 = new Customer( "max", "123456789" );
        
         /**
          *     - Inizialmente restituisce false perchè puntano a indirizzi di memoria differenti in quanto oggetti diversi 
          *     - Producono anche un diverso hashCode
          */ 
    
        System.out.println( "Equals: " + max1.equals( max2 ) );      
        System.out.println( "Max1 hashCode:" + max1.hashCode() );
        System.out.println( "Max2 hashCode:" + max2.hashCode() );

        /**
         *  - Se però ridefiniamo il metodo equals e il metodo hashCode nella classe, il metodo ritornerebbe true
         */
    }
}

class Customer{
    private String nome;
    private String cf;
    private String indirizzo;
    private String email;
    
    public Customer(String nome, String cf) {
        this.nome = nome;
        this.cf = cf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj){          
        if(this == obj) return true;
        if(!(obj instanceof Customer)) return false;

        Customer c = (Customer) obj;        //  cast per ereditarietà
        return this.nome.equals(c.nome) && this.cf.equals(c.cf);        // obj, essendo un'istanza di Object, non ha i parametri "nome" e "cf", per questo si fa il cast
    }

    @Override
    public int hashCode(){
        int primo = 11;
        return primo * cf.hashCode();
    }
}