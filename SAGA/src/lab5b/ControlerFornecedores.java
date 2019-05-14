package lab5b;

import java.util.HashMap;

/**
 * Gerencia as operacoes feitas com Fornecedores e Produtos, e armazena os fornecedores
 */
public class ControlerFornecedores {
    /**
     * Atrubuto privado que guarda os Fornecedores e os referencia pelo nome
     */
    HashMap<String, Fornecedor> fornecedores;

    /**
     * Inicializa um ControlerFornecedores com um HashMap de fornecedores vazio
     */
    public ControlerFornecedores() {
        fornecedores = new HashMap<String, Fornecedor>();
    }

    /**
     * Cria e armazena um novo fornecedor
     * @param nome
     * @param email
     * @param telefone
     * @return nome do fornecedor
     */
    public String adicionaFornecedor(String nome, String email, String telefone){
        if(fornecedores.containsKey(nome)) throw new Error("Erro no cadastro de fornecedor: fornecedor ja existe.");
        fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        return nome;
    }

    /**
     * Verifica se o fornecedor existe e retorna uma String
     * @param nome
     * @return Representação textual do fornecedor especificado
     */
    public String exibeFornecedor(String nome){
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na exibicao do fornecedor: fornecedor nao existe.");
        return fornecedores.get(nome).toString();
    }

    /**
     * Exibe todos os fornecedores já registrados
     * @return Representação textual de todos os fornecedores separados por " - "
     */
    public String exibeFornecedores(){
        String temp = new String();
        for(Fornecedor it : fornecedores.values()){
            temp += it.toString() + " - ";
        }
        return temp.length() > 2 ? temp.substring(0, temp.length() -3) : temp;
    }

    /**
     * edita um atributo do fornecedor comforme o especificado
     * @param nome nome do fornecedor a ser editado
     * @param atributo Atributo do Fornededor que deve ser editado
     *        Parametros aceitados: nome, email, telefone.
     * @param novoValor novo valor a ser atribuito ao atributo especificado
     */
    public void editaFornecedor(String nome, String atributo, String novoValor){
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na edicao do fornecedor: fornecedor nao existe.");
        if(atributo.equals("") || atributo == null) throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        if(novoValor.equals("") || novoValor == null) throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        if(atributo.equals("nome")) throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        else if(atributo.equals("email")) fornecedores.get(nome).setEmail(novoValor);
        else if(atributo.equals("telefone")) fornecedores.get(nome).setTelefone(novoValor);
        else throw new Error("Erro na edicao do fornecedor: atributo nao existe.");
    }

    /**
     * Remove um fornecedor anteriormente adicionado
     * @param nome
     */

    public void removeFornecedor(String nome){
        if(nome.equals("") || nome == null) throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na remocao do fornecedor: fornecedor nao existe.");
        fornecedores.remove(nome);
    }
    //US3

    /**
     * Adiciona um produto a um fornecedor, portanto que o fornecedor esteja registrado e o produto ainda não pertença ao fornecedor
     * obs:
     *  preço do produto deve ser >= 0
     *  e nenhum parametro pode ser vazio ou nulo
     * @param fornecedor
     * @param nome
     * @param descricao descricao atrubuida
     * @param preco
     */
    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        fornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
    }

    /**
     * Exibe um a representação textual de um produto
     * obs:
     *   O fornecedor deve estar cadastrado
     *   O produto deve pertencer ao fornecedor
     *   Nenhum dos parametros pode ser vazio ou nulo
     * @param nome nome do produto a ser exibido
     * @param descricao descricao do produto a ser exibido
     * @param fornecedor nome do fornecedor
     * @return Representação textual do produto especificado
     */
    public String exibeProduto(String nome, String descricao, String fornecedor){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro na exibicao de produto: fornecedor nao existe.");
        return fornecedores.get(fornecedor).exibeProduto(nome, descricao);
    }

    /**
     * Modifica o preco de um produto
     * obs:
     *   O fornecedor deve estar cadastrado
     *   O produto deve pertencer ao fornecedor
     *   Nenhum dos parametros pode ser vazio ou nulo
     * @param nome nome do produto a ser exibido
     * @param descricao descricao do produto a ser exibido
     * @param fornecedor nome do fornecedor
     * @param preco novo preco do produto
     * @return Nova representação textual do produto após sua alteração
     */
    public String editaProduto(String nome, String descricao, String fornecedor, double preco){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro na edicao de produto: fornecedor nao existe.");
        return fornecedores.get(fornecedor).editaProduto(nome, descricao, preco);
    }

    /**
     * Deleta um produto do fornecedor
     * @param nome
     * @param descricao
     * @param fornecedor
     */
    public void removeProduto(String nome, String descricao, String fornecedor){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro na remocao de produto: fornecedor nao existe.");
        fornecedores.get(fornecedor).removeProduto(nome, descricao);
    }
}
