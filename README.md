# Fragments
Various fragment approches for android 


Hi Friends this repository explains the various fragment approches and  
to handle how view can be designed flexibly.

Using InterFragmentCommunication model using simple interface to handle the 
data travelling from one fragment to another fragment and using bundle how to save the   
fragment state.

Flexible UI example explains how to handle landscape and potrait modes to handle listview 
and detailed view scenario. 

**Fragment that saves its state**  

![Screen](https://github.com/ashokslsk/Fragments/blob/master/LearningFragmentExcersice/screen1%20.png)

**Fragment with saved staed**
![Screen](https://github.com/ashokslsk/Fragments/blob/master/LearningFragmentExcersice/screen2.png)

**Fragment approach to flexible ui LISTVIEW**
![Screen](https://github.com/ashokslsk/Fragments/blob/master/FlexibleUI/screen1.png)

**Listview Detailed view**
![Screen](https://github.com/ashokslsk/Fragments/blob/master/FlexibleUI/screen2.png)

**Flexible same view for list and detail view**
![Screen](https://github.com/ashokslsk/Fragments/blob/master/FlexibleUI/screen3.png)  

```sh
**Fragment A**

package com.ashokslsk.flexibleui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Ashu on 12/08/15.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener{

    ListView listview;
    Communicator comm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        listview = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.titles,android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(this);
        return view;
    }


    public void setComm(Communicator comm) {
        this.comm = comm;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        comm.respond(position);
    }


    public interface Communicator{
        public void respond(int index);
    }
}


** Fragment B**

package com.ashokslsk.flexibleui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ashu on 12/08/15.
 */
public class FragmentB extends Fragment {

    TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        text = (TextView) view.findViewById(R.id.textView);
        return view;
    }


    public void changeData(int index){
        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        text.setText(descriptions[index]);
    }
}


**MAINACTIVITY**

package com.ashokslsk.flexibleui;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentA.Communicator {

    FragmentA fragment1;
    FragmentB fragment2;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        fragment1 = (FragmentA) manager.findFragmentById(R.id.fragment);

        fragment1.setComm(this);
    }

    @Override
    public void respond(int index) {

        fragment2 = (FragmentB) manager.findFragmentById(R.id.fragment2);
        if(fragment2 != null && fragment2.isVisible() ){
            // Landscape view
            fragment2.changeData(index);

        }else {
            //Portrait view
            Intent i = new Intent(MainActivity.this, AnotherActivity.class);
            i.putExtra("index", index);
            startActivity(i);
        }

    }
}

**Another Activity**

package com.ashokslsk.flexibleui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class AnotherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent intent = getIntent();
        int position = intent.getIntExtra("index", 0);
        FragmentB fragment2 = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
        if(fragment2 != null)
        fragment2.changeData(position);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_another, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

```

- Execute it as simple as it is 

* [For more codes, funs and for queries be in touch with @ashokslsk ](https://github.com/ashokslsk)











