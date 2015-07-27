package testpnr.pnr.android.com.listviewwithbaseadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    Customer customer;
    List<Customer> customerList = new ArrayList<Customer>();
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        addDataInList();
        AdapterClass adapter=new AdapterClass();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    private void addDataInList() {
        customer = new Customer();
        customer.setName("Pawan");
        customer.setPhoneNumber("9902765235");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Nadeem");
        customer.setPhoneNumber("8792865626");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Sahil");
        customer.setPhoneNumber("9643338965");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Santosh");
        customer.setPhoneNumber("9645689650");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Javed");
        customer.setPhoneNumber("8649887329");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Naman");
        customer.setPhoneNumber("9644448965");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Sidhant");
        customer.setPhoneNumber("8880568965");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Naveen");
        customer.setPhoneNumber("8009892389");
        customerList.add(customer);
        customer = new Customer();
        customer.setName("Baba");
        customer.setPhoneNumber("7638390878");
        customerList.add(customer);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AdapterClass.ViewHolder holder=(AdapterClass.ViewHolder)view.getTag();
        Customer cust=(Customer)holder.nameTextView.getTag();
        Toast.makeText(context,cust.getName()+"       "+cust.getPhoneNumber(),Toast.LENGTH_SHORT).show();
    }

    public class AdapterClass extends BaseAdapter {

        @Override
        public int getCount() {
            return customerList.size();
        }

        @Override
        public Object getItem(int position) {
            return customerList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        class ViewHolder {
            TextView nameTextView;
            TextView phoneNumberTextView;

            ViewHolder(View view) {
                nameTextView = (TextView) view.findViewById(R.id.name);
                phoneNumberTextView = (TextView) view.findViewById(R.id.phoneNumber);
            }

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row=inflater.inflate(R.layout.rowforlistview, parent, false);
                viewHolder=new ViewHolder(row);
                row.setTag(viewHolder);
            }else{
                viewHolder=(ViewHolder)row.getTag();
            }
            Customer c=customerList.get(position);
            viewHolder.nameTextView.setText(c.getName());
            viewHolder.phoneNumberTextView.setText(c.getPhoneNumber());
            viewHolder.nameTextView.setTag(c);
            return row;
        }
    }
}
