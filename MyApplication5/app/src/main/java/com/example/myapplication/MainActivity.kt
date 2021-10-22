package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ItemDialogLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class ItemDialog(val clickedItemPos:Int=-1) :BottomSheetDialogFragment() {
    private lateinit var binding: ItemDialogLayoutBinding
    private val viewModel by activityViewModels<MyViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemDialogLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item,names)
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter=adapter
        if(clickedItemPos>=0){
            val n=viewModel.items[clickedItemPos].name
            val s= names.indexOf(n)
            binding.spinner.setSelection(s)
            binding.editp.setText(viewModel.items[clickedItemPos].phone)
        }
        binding.spinner.setSelection(0)
        binding.btnOk.setOnClickListener{
            val name=binding.spinner.selectedItem as String
          val items= Item(name,binding.editp.text.toString())
            if(clickedItemPos<0)
                viewModel.addItem(items)
                else
                viewModel.updateItem(items,clickedItemPos)

            dismiss()
        }

    }
    companion object{
        val names= arrayListOf("james","tom","janes")

    }
}
class MainActivity : AppCompatActivity() {
   private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
   }
    private val viewModel by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener{
            //Snackbar.make(it,"TEST",Snackbar.LENGTH_SHORT).show()
            ItemDialog().show(supportFragmentManager,"ItemDialog")
        }
        val adapter=CustomAdapter(viewModel)
        binding.RecycleView.adapter=adapter
        binding.RecycleView.layoutManager=LinearLayoutManager(this)
        binding.RecycleView.setHasFixedSize(true)
            viewModel.itemsLiveData.observe(this){
                adapter.notifyDataSetChanged()

            }
        registerForContextMenu(binding.RecycleView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.ctx_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Edit ->ItemDialog(viewModel.longClickItem).show(supportFragmentManager,"ItemDialog")
            R.id.Delete->viewModel.deleteItem(viewModel.longClickItem)
            else -> super.onContextItemSelected(item)
        }
        return true
    }
}