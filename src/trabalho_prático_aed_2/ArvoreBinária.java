package trabalho_prático_aed_2;

import java.util.ArrayList;

public class ArvoreBinária {

    private Node root;
    public ArrayList<Pessoa> nomes = new ArrayList<>();

    public boolean isEmpty() {
        return root == null;
    }

    public int getAltura() {
        return getAltura(this.root);
    }

    private int getAltura(Node root) {
        if (root == null) {
            return 0;
        }
        int altEsq = getAltura(root.getNoEsquerda());
        int altDir = getAltura(root.getNoDireita());
        if (altEsq > altDir) {
            return altEsq + 1;
        } else {
            return altDir + 1;
        }
    }

    public int getQtdNode() {
        return getQtdNode(root);
    }

    private int getQtdNode(Node root) {
        if (root == null) {
            return 0;
        }
        int qtdNodeEsq = getQtdNode(root.getNoEsquerda());
        int qtdNodeDireita = getQtdNode(root.getNoDireita());
        return qtdNodeEsq + qtdNodeDireita + 1;
    }

    public void imprimirArvore() {
        if (this.root == null) {
            System.out.println("Árvore vazia");
        } else {
            imprimirArvore(this.root);
        }
    }

    private void imprimirArvore(Node node) {
        if (node.getNoEsquerda() != null) {
            imprimirArvore(node.getNoEsquerda());
        }
        if (node.getNoDireita() != null) {
            imprimirArvore(node.getNoDireita());
        }
        node.imprime_no();
    }

    public void inserir(Pessoa novo_contato) {
        inserir(this.root, novo_contato);
    }

    public void inserir(Node node, Pessoa novo) {
        if (this.root == null) {
            this.root = new Node(novo);
        } else {
            if (novo.getId() < node.getContato().getId()) {
                if (node.getNoEsquerda() != null) {
                    inserir(node.getNoEsquerda(), novo);
                } else {
                    //Se nodo esquerdo vazio insere o novo no aqui 
                    node.setNoEsquerda(new Node(novo));
                }
                //Verifica se o valor a ser inserido é maior que o no corrente da árvore, se sim vai para subarvore direita 
            } else if (novo.getId() > node.getContato().getId()) {
                //Se tiver elemento no no direito continua a busca 
                if (node.getNoDireita() != null) {
                    inserir(node.getNoDireita(), novo);
                } else {
                    //Se nodo direito vazio insere o novo no aqui 
                    node.setNoDireita(new Node(novo));
                }
            }
        }
    }

    public Node remover(Pessoa contato) throws Exception {
        return remover(this.root, contato);
    }

    private Node remover(Node node, Pessoa Contato) throws Exception {
        if (this.root == null) {
            throw new Exception("Árvore vazia");
        } else {
            if (Contato.getId() < node.getContato().getId()) {
                node.setNoEsquerda(remover(node.getNoEsquerda(), Contato));
            } else if (Contato.getId() > node.getContato().getId()) {
                node.setNoDireita(remover(node.getNoDireita(), Contato));
            } else if (node.getNoEsquerda() != null && node.getNoDireita() != null) {
                /*2 filhos*/
                System.out.println("  Removeu No " + node.getContato().getNome());
                node.setContato(encontraMinimo(node.getNoDireita()).getContato());
                node.setNoDireita(removeMinimo(node.getNoDireita()));
            } else {
                System.out.println("  Removeu No " + node.getContato().getNome());
                node = (node.getNoEsquerda() != null) ? node.getNoEsquerda() : node.getNoDireita();
            }
            return node;
        }
    }

    private Node removeMinimo(Node node) {
        if (node == null) {
            System.out.println("  ERRO ");
        } else if (node.getNoEsquerda() != null) {
            node.setNoEsquerda(removeMinimo(node.getNoEsquerda()));
            return node;
        } else {
            return node.getNoDireita();
        }
        return null;
    }

    private Node encontraMinimo(Node node) {
        if (node != null) {
            while (node.getNoEsquerda() != null) {
                node = node.getNoEsquerda();
            }
        }
        return node;
    }

    public Node Busca_no(String nome) {

        Node no_aux;
        no_aux = null;
        if (this.root == null) {
            System.out.println("Árvore vazia");
        } else {
            imprimirArvore(this.root);
        }

        return no_aux;
    }

    private Node Busca(Node no, String nome) {
        if (no != null) {
            if (nome.compareTo(no.getContato().getNome()) < 0) {

            } else if (nome.compareTo(no.getContato().getNome()) > 0) {

            }
        }

        return null;
    }

    public ArrayList percorre(String Nome) {
        ArrayList<Pessoa> contatos = new ArrayList<>();

        if (this.root == null) {
            System.out.println("Árvore vazia");
        } else {
            //imprimirArvore(this.root);
            contatos=percorre(this.root, Nome);
        }

        return contatos;
    }

    private ArrayList percorre(Node no, String nome) {
        

        if (no.getNoEsquerda() != null) {
            /*if(no.getNoEsquerda().getContato().getNome().contains(nome)){
                nomes.add(no.getNoEsquerda().getContato());
            }*/
            percorre(no.getNoEsquerda(), nome);
        }
        if (no.getNoDireita() != null) {
            /*if(no.getNoDireita().getContato().getNome().contains(nome)){
                nomes.add(no.getNoDireita().getContato());
            }*/
            percorre(no.getNoDireita(), nome);
        }
        if (no.getContato().getNome().contains(nome)) {
            nomes.add(no.getContato());
        }

        return nomes;
    }
}
