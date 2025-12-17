
@Entity
public class Contract
{
    @Id
    private Long id;
    @Column(unique=true)
    private String contaractNumber;
    private String title;
    private String counterpartName;
    private 
}