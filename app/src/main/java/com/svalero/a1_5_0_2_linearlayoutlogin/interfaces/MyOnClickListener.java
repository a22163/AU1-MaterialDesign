package com.svalero.a1_5_0_2_linearlayoutlogin.interfaces;

import android.view.View;
import android.widget.Toast;

import com.svalero.a1_5_0_2_linearlayoutlogin.MainActivity;


public class MyOnClickListener
        implements View.OnClickListener {
    private MainActivity padre; //0X154879F
    // 0X154879F
    public MyOnClickListener(MainActivity padre) {
        this.padre = padre;
        // 0X154879F
    }
    @Override
    public void onClick(View view) {
                String resp = "Email: " + padre.getEdtEmail().
                        getText().toString();
                resp+="- Password: " + padre.getEdtPassword().
                        getText().toString();
                Toast.makeText(padre.getBaseContext(),
                        resp,
                        Toast.LENGTH_SHORT).show();
            }
}
