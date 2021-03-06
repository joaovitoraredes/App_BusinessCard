package br.com.jv_aredess.businesscard.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.jv_aredess.businesscard.data.BusinessCard
import br.com.jv_aredess.businesscard.databinding.CardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()){

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: CardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BusinessCard) {
            if (item.tipoId == 0) {
                binding.ctRView.setBackgroundColor(0)
                binding.ctEView.setBackgroundColor(0)
                binding.ctDView.setBackgroundColor(0)
            }
            else if (item.tipoId == 1) {
                binding.ctBView.setBackgroundColor(0)
                binding.ctEView.setBackgroundColor(0)
                binding.ctDView.setBackgroundColor(0)
            }
            else if (item.tipoId == 2) {
                binding.ctBView.setBackgroundColor(0)
                binding.ctRView.setBackgroundColor(0)
                binding.ctDView.setBackgroundColor(0)
            }
            else if (item.tipoId == 3) {
                binding.ctBView.setBackgroundColor(0)
                binding.ctRView.setBackgroundColor(0)
                binding.ctEView.setBackgroundColor(0)
            }
                binding.ctNome.text = item.nome
                binding.ctTelefone.text = item.telefone
                binding.ctEmail.text = item.email
                binding.ctEmpresa.text = item.empresa
                binding.mctContent.setOnClickListener {
                    listenerShare(it)
                }
            }
        }
    }

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}