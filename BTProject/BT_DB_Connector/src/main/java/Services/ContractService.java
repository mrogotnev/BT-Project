package Services;

import Repositories.Contract;
import Repositories.ContractRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContractService {
    private ContractRepository contractRepository;

    public ContractService() {
        contractRepository = new ContractRepository();
    }

    public List<Contract> getContracts() throws SQLException {
        List<Contract> listOfContracts = contractRepository.getContracts();
        long diffMilliseconds;
        long diffDay;
        for (int i = 0; i < listOfContracts.size(); i++) {
            diffMilliseconds = listOfContracts.get(i).getUpdatedBy().getTime() - listOfContracts.get(i).getCreatedBy().getTime();
            diffDay = TimeUnit.DAYS.convert(diffMilliseconds, TimeUnit.MILLISECONDS);
            if (diffDay >= 60 || diffDay == -1) {
                listOfContracts.get(i).setIsActual(false);
            } else {
                listOfContracts.get(i).setIsActual(true);
            }
        }
        listOfContracts.get(0).setIsActual(false);
        return listOfContracts;
    }
}
