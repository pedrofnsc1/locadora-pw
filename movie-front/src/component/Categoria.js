import React from "react";
import {List, Datagrid, TextField, EditButton, DeleteButton,
        Edit, SimpleForm, TextInput} from 'react-admin';

export const ListarCategoria = props => (
  <List {...props}>
    <Datagrid>
      <TextField source="id" label="Id"/>
      <TextField source="categoriaFilme" label="Categoria de Filmes"/>
      <EditButton/>
      <DeleteButton/>
    </Datagrid>
  </List>
);

export const CriarCategoria = props => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput disabled source="id" label="ID"/>
      <TextInput source="categoriaFilme" label="Categoria de Filme"/>
    </SimpleForm>
  </Edit>
)

export const EditarCategoria = props => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput disabled source="id" label="ID"/>
      <TextInput source="categoriaFilme" label="Categoria de Filme"/>
    </SimpleForm>
  </Edit>
)