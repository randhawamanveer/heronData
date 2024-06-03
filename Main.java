import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public static List<Transaction> findRecurring(List<Transaction> transactionList){
        Map<String, List<Transaction>> transMap = new HashMap<>();

        for (Transaction t : transactionList){
            String moddedDescription = trimDespription(t.description);
            String similarStr = getSimilarStr(transMap.keySet(), moddedDescription);

            if (similarStr != null){
                double points = getSmilarity(moddedDescription, similarStr) * 2.0;

                Transaction last = transMap.get(similarStr).getLast();
                if (t.amount == last.amount){
                    points += 1.0;
                }

                points += getAverageTransactionsPeriod(transMap.get(moddedDescription), t);

                if (points > 2.0){
                    transMap.get(moddedDescription).add(t);
                    continue;
                }
            }

            transMap.put(moddedDescription, new ArrayList<>());
            transMap.get(moddedDescription).add(t);
        }

        List<Transaction> recurring = new ArrayList<>();
        for (List<Transaction> list : transMap.values()){
            if (list.size() > 2){
                recurring.addAll(list);
            }
        }

        return recurring;
    }

}

class Transaction {
    String description;
    int amount;
    Date date;

}