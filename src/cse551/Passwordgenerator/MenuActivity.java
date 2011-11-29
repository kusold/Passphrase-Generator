package cse551.Passwordgenerator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends ApplicationActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		ListView menuList = (ListView) findViewById(R.id.ListView_Menu);

        String[] items = { getResources().getString(R.string.menu_item_generate),
                getResources().getString(R.string.menu_item_help) };
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
        menuList.setAdapter(adapt);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {

                // Note: if the list was built "by hand" the id could be used.
                // As-is, though, each item has the same id

                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();

                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_generate))) {
                    // Launch the Game Activity
                    startActivity(new Intent(MenuActivity.this, GeneratorActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_help))) {
                    // Launch the Help Activity
                    startActivity(new Intent(MenuActivity.this, HelpActivity.class));
                
                }

            }
        });
	}

}
