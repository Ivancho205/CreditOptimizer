package com.creditoptimizer.backend_creditoptimizer.application;
import com.creditoptimizer.backend_creditoptimizer.domain.EntityTransaction;
import com.fasterxml.jackson.annotation.JsonTypeInfo.None;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private List<EntityTransaction> transactionList;

    public TransactionService() {
        transactionList = new ArrayList<>();

        EntityTransaction transaction1 = new EntityTransaction(1, "Ada", "enos", "enos", 3.4, 3, true);
        EntityTransaction transaction2 = new EntityTransaction(2, "Bdan", "enos2", "enos1", 4.4, 7, true);
        EntityTransaction transaction3 = new EntityTransaction(3, "Cdai", "enos3", "enos2", 5.4, 2, false);
        EntityTransaction transaction4 = new EntityTransaction(4, "Ddani", "enos4", "enos3", 6.4, 4, false);
        EntityTransaction transaction5 = new EntityTransaction(5, "Edanaan", "enos5", "enos4", 7.4, 5, true);


        transactionList.addAll(Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5));

    }


    public List<EntityTransaction> consultar() {
        return transactionList;
    }
    public Optional<EntityTransaction> consultarPorId(int idTransaction) {
        Optional optional = Optional.empty();
        for (EntityTransaction transaction: transactionList) {
            if(idTransaction == transaction.id()){
                optional = Optional.of(transaction);
                return optional;
            }
        }
        return optional;
    }
    public String ingresar(EntityTransaction transaction) {
        transactionList.add(transaction);
        return "Ingresado con éxito";
    }

    public String modificar(int idTransaction, EntityTransaction transaction) {
        transactionList =
        transactionList.stream().map(item->item.id() == transaction.id() ? transaction : item).toList();
        return "Modificado con éxito el ID: " + idTransaction;
    }
    public String eliminar(int idTransaction) {
        transactionList =
        transactionList.stream().map(item->item.id() == idTransaction ? null : item).toList();
        return "Eliminado con éxito el ID: " + idTransaction;
    }
}
