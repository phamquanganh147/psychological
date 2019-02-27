package dev147.com.vn.projectpsychological.ui.customer;

import dev147.com.vn.projectpsychological.R;
import dev147.com.vn.projectpsychological.databinding.FragmentCustomerBinding;
import dev147.com.vn.projectpsychological.ui.base.BaseFragment;
import dev147.com.vn.projectpsychological.utils.Fields;
import dev147.com.vn.projectpsychological.utils.Utils;

public class CustomerFragment extends BaseFragment<CustomerViewModel, FragmentCustomerBinding> {
    @Override
    protected void initView() {
        binding.tvTitle1.setTypeface(Utils.getTypeFace(getContext(), Fields.FONT_NABILA));
    }

    @Override
    protected void initData() {

    }

    @Override
    public Class<CustomerViewModel> getModelClass() {
        return CustomerViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_customer;
    }
}
