
@Entity
public class Contract
{
    @Id
    private Long id;
    @Column(unique=true)
    private String contaractNumber;
    private String title;
    private String counterpartName;
    private Date agreedDeliveryDate;
    private BigDecimal baseContractValue;
    private String status;
    private Timestamp createdAT;
    private Timestamp Timestamp;

    //id
    public void setID(Long id)
    { this.id=id; }
    public Long getID()
    { return id; }

    //contaractNumber
    public void setcontaractNumber(String contaractNumber)
    { this.contaractNumber=contaractNumber; }
    public String getID()
    { return id; }

}