package dev147.com.vn.projectpsychological.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev147.com.vn.projectpsychological.ui.customer.CustomerFragment;
import dev147.com.vn.projectpsychological.ui.home.HomeFragment;
import dev147.com.vn.projectpsychological.ui.main.MainActivity;
import dev147.com.vn.projectpsychological.ui.question.QuestionFragment;
import dev147.com.vn.projectpsychological.ui.question.QuestionViewModel;
import dev147.com.vn.projectpsychological.ui.splash.SplashActivity;
import dev147.com.vn.projectpsychological.ui.tutorial.TutorialActivity;

@Module
public abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract TutorialActivity bindTutorialActivity();

    @ContributesAndroidInjector
    abstract HomeFragment bindHomeFragment();

    @ContributesAndroidInjector
    abstract CustomerFragment bindCustomerFragment();

    @ContributesAndroidInjector
    abstract QuestionFragment bindQuestionFragment();
}
