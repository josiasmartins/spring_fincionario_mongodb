# Funcionario Api spring noSql (Mongodb)

## how use mongodb in spring boot (java)

#### add uri for mongo db

```properties
spring.data.mongodb.uri:mongodb://localhost/folhapagamento
spring.data.mongodb.username=
spring.data.mongodb.password=
```

#### Create class document (entity)
```java
@Data
@Document(value = "funcionario")
public class Funcionario {

    @Id
    private String codigo;

    private String nome;

    private Integer idade;

    private BigDecimal salario;

    @DBRef // referencia uma collection dentro de outra
    private Funcionario chefe;

}

```

#### create repository 
```java
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    // $and: serve para agrupar duas comparações
    // $gt: green than. $gte: greem than equal
    // $lt: less than
    @Query("{ $and: [ { 'idade': { $gte: ?0 } }, { 'idade': { $lte: ?1 } } ] }")
    public List<Funcionario> obterFuncionariosPorIdade(Integer de, Integer ate);

    public List<Funcionario> findByNome(String nome);

}
```

## Runner local


## Runner with docker


#### Links:
[Utilizando MongoDB com Spring Data](https://www.youtube.com/watch?v=Qkmwgyh4Stw)
<br>
[Começando com MongoDB](https://www.youtube.com/watch?v=jC7imm4ZLRY)