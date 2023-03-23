package id.ac.unpas.pencatatankeuangan.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.unpas.pencatatankeuangan.model.PencatatanKeuangan
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PengelolaanKeuanganScreen() {
    val _list = remember { MutableStateFlow(listOf<PencatatanKeuangan>()) }
    val list by remember { _list }.collectAsState()
    Column(modifier = Modifier.fillMaxWidth()) {
        FormPencatatanKeuangan { item ->
            val newList = ArrayList(list)
            newList.add(item)
            _list.value = newList
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = list, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {

                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal", fontSize = 14.sp)
                        Text(text = item.tanggal, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Keterangan", fontSize = 14.sp)
                        Text(text = item.keterangan, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Pemasukan", fontSize = 14.sp)
                        Text(text = "${item.pemasukan}", fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Pengeluaran", fontSize = 14.sp)
                        Text(text = "${item.pengeluaran}", fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}