package com.example.alejandro_neri.city_tourister;


import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WizardActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager mPager;
    private int[] layouts = {R.layout.wizard_first_slide, R.layout.wizard_second_slide, R.layout.wizard_third_slide};
    private MPagerAdapter mPagerAdapter;
    private LinearLayout dotsLayout;
    private ImageView[] dots;
    private Button btnSkip, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //if (new PreferenceManager(this).checkPreferences())
        //  loadHome();
        // esto hará que la barra de hasta arriba sea de color transparente
        if (Build.VERSION.SDK_INT >= 19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_wizard);
        mPager = (ViewPager) findViewById(R.id.viewPager);

        mPagerAdapter = new MPagerAdapter(layouts, this);
        mPager.setAdapter(mPagerAdapter);

        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        createDots(0);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
            }

            @Override
            public void onPageSelected(int position){
                createDots(position);
                if (position == layouts.length - 1) {
                    btnNext.setText("START");
                    btnSkip.setVisibility(View.INVISIBLE);
                } else {
                    btnNext.setText("NEXT");
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state){
            }
        });
    }

    private void createDots(int currentPosition){
        if (dotsLayout != null)
            dotsLayout.removeAllViews();

        dots = new ImageView[layouts.length];
        for (int i = 0; i < layouts.length; i++){
            dots[i] = new ImageView(this);
            if (i == currentPosition){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));

            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            dotsLayout.addView(dots[i], params);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNext:
                loadNextSlide();
                break;
            case R.id.btnSkip:
                loadHome();
                new PreferenceManager(this).writePreferences();
                break;
        }
    }

    private void loadHome(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void loadNextSlide(){
        int nextSlide = mPager.getCurrentItem()+1;
        if (nextSlide < layouts.length)
            mPager.setCurrentItem(nextSlide);
        else{
            loadHome();
            new PreferenceManager(this);
        }

    }
}
