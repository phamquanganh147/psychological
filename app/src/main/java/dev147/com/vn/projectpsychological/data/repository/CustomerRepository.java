package dev147.com.vn.projectpsychological.data.repository;

import dev147.com.vn.projectpsychological.data.AbstractAppDatabase;
import dev147.com.vn.projectpsychological.data.model.Customer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class CustomerRepository {
    private AbstractAppDatabase abstractAppDatabase;

    @Inject
    public CustomerRepository(AbstractAppDatabase abstractAppDatabase) {
        this.abstractAppDatabase = abstractAppDatabase;
    }

    public Single<Customer> getCustomerById(int customerId) {
        return abstractAppDatabase.customerDao().getCustomerById(customerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Long> getCount(){
        return abstractAppDatabase.customerDao().getCountCustomer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
