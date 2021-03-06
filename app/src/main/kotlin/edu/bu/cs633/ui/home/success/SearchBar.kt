package edu.bu.cs633.ui.home.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    option: SortOption,
    options: List<SortOption>,
    onOptionChanged: (SortOption) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column {
            Row {
                TextField(
                    modifier = Modifier
                        .padding(8.dp),
                    value = query,
                    onValueChange = onQueryChanged,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                    ),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Search, "")
                    },
                    keyboardActions = KeyboardActions(onDone = {
                        keyboardController?.hide()
                    }),
                    placeholder = {
                        Text(text = "Search by location")
                    }
                )
                IconButton(
                    onClick = { expanded = true }
                ) {
                    Icon(imageVector = Icons.Filled.Sort, contentDescription = "")
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        options.forEach { option ->
                            DropdownMenuItem(onClick = {
                                onOptionChanged(option)
                                expanded = false
                            }) {
                                Text(text = option.value)
                            }
                        }
                    }
                }
            }
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Sorted by: ${option.value}"
            )
        }
    }
}