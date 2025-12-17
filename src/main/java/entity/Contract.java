
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
    public void setContaractNumber(String contaractNumber)
    { this.contaractNumber=contaractNumber; }
    public String getContaractNumber()
    { return contaractNumber; }

    //title
    public void setTitle(String title)
    { this.title=title; }
    public String getTitle()
    { return title; }

    //counterpartName
    public void setCounterpartName(String counterpartName)
    { this.counterpartName=counterpartName; }
    public String getCounterpartName()
    { return counterpartName; }

    


}