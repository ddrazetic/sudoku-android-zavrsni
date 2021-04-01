package hr.ferit.drazetic.sudokuapp.hr.ferit.drazetic.sudokuapp.view.sudokugrid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;


import hr.ferit.drazetic.sudokuapp.GameEngine;
import hr.ferit.drazetic.sudokuapp.R;

public class SudokuGridView extends GridView {

    private final Context context;

    public SudokuGridView showGrid;

    public SudokuGridView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        final SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);

        setAdapter(gridViewAdapter);

        showGrid=(SudokuGridView) findViewById(R.id.sudokuGridView) ;

        final int[] previousPosition = {-1};
        final int[] ink = {0};

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 9;
                int y = position / 9;
                GameEngine.getInstance().setSelectedPosition(x,y);

                if(previousPosition[0]!=-1){
                    showGrid.getChildAt(previousPosition[0]).setBackgroundColor(ink[0]);
                }
                ColorDrawable cr=(ColorDrawable) showGrid.getChildAt(position).getBackground();
                ink[0] =cr.getColor();
                showGrid.getChildAt(position).setBackgroundColor(Color.MAGENTA);
                previousPosition[0] =position;
            }
        });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);

    }




}

class SudokuGridViewAdapter extends BaseAdapter {


    private Context context;

    public SudokuGridViewAdapter(Context context) {

        this.context = context;
    }


    @Override
    public int getCount() {
        return 81;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        return GameEngine.getInstance().getGrid().getItem(position);


    }
}

