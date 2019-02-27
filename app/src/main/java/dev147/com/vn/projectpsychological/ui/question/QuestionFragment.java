package dev147.com.vn.projectpsychological.ui.question;

import dev147.com.vn.projectpsychological.R;
import dev147.com.vn.projectpsychological.databinding.DetailQuestionBinding;
import dev147.com.vn.projectpsychological.ui.base.BaseFragment;

public class QuestionFragment extends BaseFragment<QuestionViewModel, DetailQuestionBinding> {
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public Class<QuestionViewModel> getModelClass() {
        return QuestionViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.detail_question;
    }
}
