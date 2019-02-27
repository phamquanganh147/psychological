package dev147.com.vn.projectpsychological.ui.splash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dev147.com.vn.projectpsychological.data.base.ObjectResponse;
import dev147.com.vn.projectpsychological.data.model.Customer;
import dev147.com.vn.projectpsychological.data.repository.CustomerRepository;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

public class SplashViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable;
    private CustomerRepository repository;

    private MutableLiveData<ObjectResponse<Customer>> customer;
    private MutableLiveData<ObjectResponse<Long>> isDataCustomer;

    @Inject
    SplashViewModel(CustomerRepository customerRepository) {
        compositeDisposable = new CompositeDisposable();
        this.repository = customerRepository;

        customer = new MutableLiveData<>();
        isDataCustomer = new MutableLiveData<>();
    }

    public void getCount() {
        compositeDisposable.add(repository.getCount()
                .doOnSubscribe(dispose -> isDataCustomer.setValue(new ObjectResponse<Long>().loading()))
                .subscribe(response ->
                                isDataCustomer.setValue(new ObjectResponse<Long>().success(response))
                        , throwable -> {
                            throwable.printStackTrace();
                            isDataCustomer.setValue(new ObjectResponse<Long>().error(throwable));
                        })
        );
    }

    public MutableLiveData<ObjectResponse<Long>> getCountCustomer() {
        return isDataCustomer;
    }


//    public void getCustomer() {
//        compositeDisposable.add(repository.getCount()
//                .doOnSubscribe(dispose -> customer.setValue(new ObjectResponse<Customer>().loading()))
//                .subscribe(response ->
//                                customer.setValue(new ObjectResponse<Customer>().success(response))
//                        , throwable -> {
//                            throwable.printStackTrace();
//                            customer.setValue(new ObjectResponse<Customer>().error(throwable));
//                        })
//        );
//    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }
}
