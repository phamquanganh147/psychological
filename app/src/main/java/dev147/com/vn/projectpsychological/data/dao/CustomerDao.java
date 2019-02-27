package dev147.com.vn.projectpsychological.data.dao;

import androidx.room.Dao;
import androidx.room.Query;
import dev147.com.vn.projectpsychological.data.model.Customer;
import dev147.com.vn.projectpsychological.utils.Define;
import io.reactivex.Single;

@Dao
public interface CustomerDao {

    @Query("SELECT count(*) FROM " + Define.Customer.TABLE_NAME)
    Single<Long> getCountCustomer();

    @Query("SELECT * FROM " + Define.Customer.TABLE_NAME + " WHERE " + Define.Customer.ID + " = :id")
    Single<Customer> getCustomerById(int id);
}
