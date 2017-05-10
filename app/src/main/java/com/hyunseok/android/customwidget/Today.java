package com.hyunseok.android.customwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017-02-21.
 */

public class Today extends android.support.v7.widget.AppCompatTextView { // Origin : extends TextView

    public Today(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 커스텀 위젯에 커스텀 속성 사용하기
        // 1. res/values/attrs.xml에 정의된 어트리뷰트를 가져온다.
        TypedArray typed = context.obtainStyledAttributes(attrs, R.styleable.Today);
        // 2. 해당 이름으로 정의된 속성의 개수를 가져오고
        int size = typed.getIndexCount();
        // 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
        for( int i = 0; i < size; i++ ) {
            // 3.1 현재 속성의 아이디 가져오기
            int cur_attr = typed.getIndex(i);

            switch (cur_attr) {
                case R.styleable.Today_delimeter:
                    // 3.3 현재 속성에 입력되어있는 값을 꺼낸다.
                    String delimeter = typed.getString(cur_attr);
                    setDate(delimeter);
                    break;
            }
        }
    }

    private void setDate(String delimeter) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+delimeter+"MM"+delimeter+"dd");

        setText(sdf.format(today));
    }
}
