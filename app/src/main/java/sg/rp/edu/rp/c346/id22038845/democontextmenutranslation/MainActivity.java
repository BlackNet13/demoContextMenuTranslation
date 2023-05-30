package sg.rp.edu.rp.c346.id22038845.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;

    String wordClicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText=findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2=findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvTranslatedText){
            menu.add(0,0,0, R.string.english);
            menu.add(0,1,1, R.string.italian);

            //wordClicked = "hello";
        }else if(v ==tvTranslatedText2){
            menu.add(1,0,0, R.string.english);
            menu.add(1,1,1, R.string.italian);
            //wordClicked = "bye";
        }

        //menu.add(0,0,0, R.string.english);
        //menu.add(0,1,1, R.string.italian);

        /*creation of submenu and adding items to submenu */
        /*SubMenu sMenu = menu.addSubMenu(1,0,0,"Other");
        sMenu.add(1,0,0,"Chinese");
        sMenu.add(1,1,1,"Japanese");*/

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        //if (wordClicked.equalsIgnoreCase("hello")) {
        if (item.getGroupId() == 0){
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText(getResources().getString(R.string.hello));

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                //Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText(getResources().getString(R.string.helloI));

                return true;  //menu item successfully handled
            }


        //}else if(wordClicked.equalsIgnoreCase("bye")){
            }else if(item.getGroupId()==1){
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                tvTranslatedText2.setText(getResources().getString(R.string.bye));

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                tvTranslatedText2.setText(getResources().getString(R.string.helloI));

                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}