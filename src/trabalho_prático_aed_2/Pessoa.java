package trabalho_prático_aed_2;

public class Pessoa {
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;
    
    public Pessoa(){
        
    }
    
    public Pessoa(String Nome,String end,String tel){
        super();
        this.id=0;
        this.nome=Nome;
        this.endereco=end;
        this.telefone=tel;        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
