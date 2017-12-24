package trabalho_prático_aed_2;

public class Node {

    private Pessoa contato;
    private Node noEsquerda;
    private Node noDireita;

    public Node() {
    }

    public Node(Pessoa cont) {
        super();
        this.contato = cont;
    }

    public Pessoa getContato() {
        return contato;
    }

    public void setContato(Pessoa Cont) {
        this.contato = Cont;
    }

    public Node getNoEsquerda() {
        return noEsquerda;
    }

    public void setNoEsquerda(Node noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

    public Node getNoDireita() {
        return noDireita;
    }

    public void setNoDireita(Node noDireita) {
        this.noDireita = noDireita;
    }

    @Override
    public String toString() {
        return "Node [Contato=" + contato.getNome() +"\n Endereco="+ contato.getEndereco()+"\n Telefone="+contato.getTelefone() +"]";
    }
    
    public void imprime_no(){
        System.out.println("Contato=" + this.contato.getNome()+"("+this.contato.getId() +")" +"\n Endereco="+ this.contato.getEndereco()+"\n Telefone="+this.contato.getTelefone());
    }
}
