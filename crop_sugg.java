package com.example.homepage;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


public class cropSuggestionActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_SOIL = 1;
    private static final int PICK_IMAGE_CROP = 2;
    private EditText fieldSizeInput, cropNameInput, cityInput;
    private ImageView soilImageView, cropImageView;
    private Button uploadSoilBtn, uploadCropBtn;
    private Bitmap soilBitmap, cropBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_suggestion);

        //fieldSizeInput = findViewById(R.id.editTextText);
        cropNameInput = findViewById(R.id.editTextText2);
        cityInput = findViewById(R.id.editTextText3);
        //soilImageView = findViewById(R.id.imageView);
        cropImageView = findViewById(R.id.imageView2);
        //uploadSoilBtn = findViewById(R.id.soilUploadbtn);
        uploadCropBtn = findViewById(R.id.cropUploadbtn);



        //uploadSoilBtn.setOnClickListener(v -> selectImage(PICK_IMAGE_SOIL));
        uploadCropBtn.setOnClickListener(v -> selectImage(PICK_IMAGE_CROP));
    }

    private void selectImage(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                if (requestCode == PICK_IMAGE_SOIL) {
                    soilBitmap = bitmap;
                    soilImageView.setImageBitmap(bitmap);
                } else if (requestCode == PICK_IMAGE_CROP) {
                    cropBitmap = bitmap;
                    cropImageView.setImageBitmap(bitmap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//
//    public void analyzeData(View view) {
//        String fieldSize = fieldSizeInput.getText().toString();
//        String cropName = cropNameInput.getText().toString();
//        String city = cityInput.getText().toString();
//
//        if (fieldSize.isEmpty() || cropName.isEmpty() || city.isEmpty()) {
//            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        fetchWeather(city);
//    }

//    private <RequestQueue, JsonObjectRequest> void fetchWeather(String city) {
//        String apiKey = "YOUR_OPENWEATHERMAP_API_KEY";
//        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                response -> {
//                    try {
//                        JSONObject main = response.getJSONObject("main");
//                        double temperature = main.getDouble("temp") - 273.15;
//                        provideSuggestions(temperature);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                },
//                error -> Toast.makeText(this, "Error fetching weather data", Toast.LENGTH_SHORT).show()
//        );
//
//        queue.add(request);
//    }

//    private void provideSuggestions(double temperature) {
//        String cropName = cropNameInput.getText().toString().toLowerCase();
//        Map<String, String> cropConditions = new HashMap<>();
//        cropConditions.put("wheat", "Wheat grows best between 10°C - 25°C with moderate rainfall.");
//        cropConditions.put("rice", "Rice requires 21°C - 37°C with high humidity and water availability.");
//        cropConditions.put("corn", "Corn thrives at 18°C - 32°C with well-drained soil.");
//        cropConditions.put("soybean", "Soybeans grow best between 20°C - 30°C with moderate rainfall.");
//
//        String suggestion = cropConditions.getOrDefault(cropName, "No specific data available for this crop.");
//        suggestion += "\nCurrent temperature: " + temperature + "°C";
//
//        Toast.makeText(this, suggestion, Toast.LENGTH_LONG).show();
//    }
    }

