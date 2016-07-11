package com.dhruv.tictactoetable;



import java.util.Arrays;

import com.dhruv.tictactoe.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView pos11,pos12,pos13,pos21,pos22,pos23,pos31,pos32,pos33;
	TextView p1,p2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pos11 = (ImageView)findViewById(R.id.pos11);
		pos12 = (ImageView)findViewById(R.id.pos12);
		pos13 = (ImageView)findViewById(R.id.pos13);
		pos21 = (ImageView)findViewById(R.id.pos21);
		pos22 = (ImageView)findViewById(R.id.pos22);
		pos23 = (ImageView)findViewById(R.id.pos23);
		pos31 = (ImageView)findViewById(R.id.pos31);
		pos32 = (ImageView)findViewById(R.id.pos32);
		pos33 = (ImageView)findViewById(R.id.pos33);
		p1 = (TextView)findViewById(R.id.p1);
		p2 = (TextView)findViewById(R.id.p2);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//set parameters
	int count=0;
	int setvalue = 2;
	Bitmap myBitmap = null;
	int[] data = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	public void buttonclicked(View view){
		//Toast.makeText(getApplicationContext(), "clicked"+R.id.,Toast.LENGTH_SHORT).show();
		count++;
		
		switch(view.getId()){
		case R.id.pos11: 
		    //click on btn11
			//Toast.makeText(getApplicationContext(), "clicked 11",Toast.LENGTH_SHORT).show();
			update(00 , pos11 , count);
			break;
		case R.id.pos12:
		    //click on btn12
			//Toast.makeText(getApplicationContext(), "clicked 12",Toast.LENGTH_SHORT).show();
			update(01 , pos12 , count);
			break;
		case R.id.pos13:
		    //click on btn13
			//Toast.makeText(getApplicationContext(), "clicked 13",Toast.LENGTH_SHORT).show();
			update(02 , pos13 , count);
			break;
		case R.id.pos21: 
		    //click on btn21
			//Toast.makeText(getApplicationContext(), "clicked 21",Toast.LENGTH_SHORT).show();
			update(03 , pos21 , count);
			break;
		case R.id.pos22:
		    //click on btn22
			//Toast.makeText(getApplicationContext(), "clicked 22",Toast.LENGTH_SHORT).show();
			update(04 , pos22 , count);
			break;
		case R.id.pos23:
		    //click on btn23
			//Toast.makeText(getApplicationContext(), "clicked 23",Toast.LENGTH_SHORT).show();
			update(05 , pos23 , count);
			break;
		case R.id.pos31: 
		    //click on btn31
			//Toast.makeText(getApplicationContext(), "clicked 31",Toast.LENGTH_SHORT).show();
			update(06 , pos31 , count);
			break;
		case R.id.pos32:
		    //click on btn32
			//Toast.makeText(getApplicationContext(), "clicked 32",Toast.LENGTH_SHORT).show();
			update(07 , pos32 , count);
			break;
		case R.id.pos33:
		    //click on btn33
			//Toast.makeText(getApplicationContext(), "clicked 33",Toast.LENGTH_SHORT).show();
			update(8, pos33 , count);
			break;
		}
		
	};
	
	public void update(int pos,ImageView id , int count){
		
		//Toast.makeText(getApplicationContext(), "c="+count, Toast.LENGTH_LONG).show();
		/* Check if "x" or "o" */
		if(count == 2 || count == 4 || count == 6 || count == 8)
		{
			// player 2 turn
			myBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.o);
			//Toast.makeText(getApplicationContext(), id + " even "+ count ,Toast.LENGTH_SHORT).show();
			setvalue = 0;
			p1.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
			p2.setBackgroundColor(getResources().getColor(android.R.color.white));
			
		}
		
		else if(count == 1 || count == 3 || count ==5 || count ==7 || count == 9)
		{
			// player 1 turn 
			myBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.x);
			setvalue = 1;
			p2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
			p1.setBackgroundColor(getResources().getColor(android.R.color.white));
		}
		/* Check if "x" or "o" */
		/*set Image image in position and turn it deaf*/
		ImageView resource = id;
    	resource.setImageBitmap(myBitmap);
    	resource.setClickable(false);
		/*set Image image in position and turn it deaf*/
		
    	/*split to set values in array */
    	int target = pos;
    	
    	/* Update array */
    	
    	data[target] = setvalue;
    	Log.i("Array", "arr = " + Arrays.toString(data));
    	/* Update array */
    	Checkstatus();
	}
	public void Checkstatus(){
	if(count < 4)
	{
		
	}
	
	else if( count >= 4){
			if(	(data[0]== 1 && data[4] == 1 && data[8] == 1) ||
			(data[2]== 1 && data[4] == 1 && data[6] == 1) ||
			(data[0]== 1 && data[1] == 1 && data[2] == 1) ||
			(data[3]== 1 && data[4] == 1 && data[5] == 1) ||
			(data[6]== 1 && data[7] == 1 && data[8] == 1) ||
			(data[0]== 1 && data[3] == 1 && data[6] == 1) ||
			(data[1]== 1 && data[4] == 1 && data[7] == 1) ||
			(data[2]== 1 && data[5] == 1 && data[8] == 1) )
			{
				Wincase(1);
			}
			else if(	(data[0]== 0 && data[4] == 0 && data[8] == 0) ||
			(data[2]== 0 && data[4] == 0 && data[6] == 0) ||
			(data[0]== 0 && data[1] == 0 && data[2] == 0) ||
			(data[3]== 0 && data[4] == 0 && data[5] == 0) ||
			(data[6]== 0 && data[7] == 0 && data[8] == 0) ||
			(data[0]== 0 && data[3] == 0 && data[6] == 0) ||
			(data[1]== 0 && data[4] == 0 && data[7] == 0) ||
			(data[2]== 0 && data[5] == 0 && data[8] == 0) )
			{
				Wincase(0);
			}
			else if (count == 9){
				Wincase(2);
			}
		}
	}
	public void Wincase(int num)
	{
		if(num == 0)
		{
			Toast.makeText(getApplicationContext(), "Winner is 0", Toast.LENGTH_LONG).show();
			Intent i = new Intent(this, Score.class);
			i.putExtra("winnername", "Player 2 Wins");
			startActivity(i); 

		}else if(num == 1)
		{
			Toast.makeText(getApplicationContext(), "Winner is 1", Toast.LENGTH_LONG).show();
			Intent i = new Intent(this, Score.class);
			i.putExtra("winnername", "Player 1 Wins !! ");
			startActivity(i); 
		}
		else if(num == 2)
		{
			Toast.makeText(getApplicationContext(), "Winner is 1", Toast.LENGTH_LONG).show();
			Intent i = new Intent(this, Score.class);
			i.putExtra("winnername", "Its a draw ");
			startActivity(i); 
		}
	
	}
}