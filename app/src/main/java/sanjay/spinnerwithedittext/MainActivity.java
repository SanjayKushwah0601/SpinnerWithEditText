package sanjay.spinnerwithedittext;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        CourseAdapter adapter = new CourseAdapter(this, R.layout.list_view_row_layout, R.layout.list_view_row_layout);
        listView.setAdapter(adapter);

        ArrayList<String> spArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            spArray.add(i + "");
        }
        for (int i = 0; i < 100; i++) {
            adapter.add(new CourseClass(spArray, "ABC"));
        }

    }


    public class CourseAdapter extends ArrayAdapter<CourseClass> {
        private final int layoutResourceId;
        Context context;

        public CourseAdapter(Context context, int layoutResourceId, int resource) {
            super(context, resource);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
        }

        @Override
        public void add(CourseClass object) {
            super.add(object);
        }

        @Override
        public void remove(CourseClass object) {
            super.remove(object);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public int getCount() {
            return super.getCount();
        }


        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View row = convertView;
            final ViewHolder holder;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(R.layout.list_view_row_layout, null);
                holder = new ViewHolder();
                holder.courseSpinner = (Spinner) row.findViewById(R.id.ListViewSpinner);
                holder.courseCrn = (EditText) row.findViewById(R.id.ListViewEditText);

                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }
            final CourseClass course = (CourseClass) getItem(position);
            holder.courseCrn.setText(course.getCourse_crn());
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, course.getCourse_name());
            holder.courseSpinner.setAdapter(arrayAdapter);
            holder.courseCrn.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    course.setCourse_crn(s.toString());
                }
            });
            return row;
        }

        public class ViewHolder {
            Spinner courseSpinner;
            EditText courseCrn;
        }
    }
}
