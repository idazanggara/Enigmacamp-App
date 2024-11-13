package com.example.enigmacampapp.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmacampapp.R
import com.example.enigmacampapp.presentation.home.model.ContactModel

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var contactsList = ArrayList<ContactModel>()


//    private var contactName = arrayOf(
//        "Idaz Anggara",
//        "Lara McEwan",
//        "Victor Mancini",
//        "Mira Holt",
//        "Diana Firdaus",
//        "Marco Cavalli",
//        "Sophia Aranda",
//        "James O'Reilly",
//        "Natalie Benitez",
//        "Carlos Estevez",
//        "Emily Dawson"
//    )
//
//    private var contactJob = arrayOf(
//        "Android Developer",
//        "Backend Developer",
//        "Frontend Developer",
//        "QA Engineer",
//        "Android Developer",
//        "Android Developer",
//        "Project Manager",
//        "UI/UX Designer",
//        "Data Analyst",
//        "DevOps Engineer",
//        "Product Manager"
//    )
//
//    private var contactImage = intArrayOf(
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact,
//        R.drawable.ic_account_circle_contact
//    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
//        holder.itemContactName.text = contactName[position]
//        holder.itemContactJob.text = contactJob[position]
//        holder.itemContactImage.setImageResource(contactImage[position])
        holder.itemContactName.text = contactsList[position].name
        holder.itemContactJob.text = contactsList[position].job
        holder.itemContactImage.setImageResource(contactsList[position].contactImage)
    }

    override fun getItemCount(): Int = contactsList.size

    fun setContact(newContact: List<ContactModel>) {
        // seperti ini saja sudah bisa, namun mungkin kurang optimal
//        contactsList.clear()
//        contactsList.addAll(newContact)
//        notifyDataSetChanged() //

        val diffCallback = ContactDiffCallback(contactsList, newContact)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        contactsList.clear()
        contactsList.addAll(newContact)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ContactDiffCallback(
        private val oldList: List<ContactModel>,
        private val newList: List<ContactModel>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].name == newList[newItemPosition].name
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemContactImage: ImageView = itemView.findViewById(R.id.contact_image)
        var itemContactName: TextView = itemView.findViewById(R.id.tv_contact_name)
        var itemContactJob: TextView = itemView.findViewById(R.id.tv_contact_job)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on ${contactsList[position]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}