package com.example.myapplication

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    val photos=ArrayList<Photo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        requestSinglePermission(Manifest.permission.READ_EXTERNAL_STORAGE)

      showPhotos()
    }
    private fun showPhotos(){
        readMedia()
        val adapter=MyAdapter(this,photos)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
    }
    private fun hasPermission(perm:String)=
        checkSelfPermission(perm)==PackageManager.PERMISSION_GRANTED
    private fun readMedia() {
        if (!hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE))
            return
        val collection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }
        val projection =
            arrayOf(MediaStore.Images.ImageColumns._ID, MediaStore.Images.ImageColumns.TITLE)
        val cursor = contentResolver.query(collection, projection, null, null, null)
        photos.clear()
        cursor?.apply {
            val idCol = getColumnIndex(MediaStore.Images.ImageColumns._ID)
            val titleCol = getColumnIndex(MediaStore.Images.ImageColumns.TITLE)
            while (moveToNext()) {
                val id = getLong(idCol)
                val title = getString(titleCol)
                photos.add(Photo(id,title))
            }
            close()
        }
    }
        @SuppressLint("StringFormatInvalid")
    private fun requestSinglePermission(permission: String){
        if(checkSelfPermission(permission)==PackageManager.PERMISSION_GRANTED)
            return
        val requestPermLauncher=registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if(it==false){
                AlertDialog.Builder(this).apply{
                    setTitle("Warning")
                    setMessage(getString(R.string.no_permission,permission))
                }.show()
            }else{
                showPhotos()
            }
        }
        if(shouldShowRequestPermissionRationale(permission)){
            AlertDialog.Builder(this).apply{
                setTitle("reason")
                setMessage(getString(R.string.req_permission_reason,permission))
                setPositiveButton("Allow") { _, _ -> requestPermLauncher.launch(permission) }
                setNegativeButton("Deny") { _, _ -> }

            }.show()
        }else{
            requestPermLauncher.launch(permission)
        }
    }

}
