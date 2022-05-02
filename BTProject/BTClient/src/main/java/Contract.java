import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Date;

@JsonAutoDetect
public class Contract {
    private int number;
    private Date createdBy;
    private Date updatedBy;
    private boolean isActual;

    public Contract(){

    }

    public Contract(int number, Date createdBy, Date updatedBy, boolean isActual) {
        this.number = number;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.isActual = isActual;
    }

    public int getNumber() {
        return number;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public Date getUpdatedBy() {
        return updatedBy;
    }

    public boolean getIsActual() {
        return isActual;
    }
}
