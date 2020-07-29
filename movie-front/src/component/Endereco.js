import React from 'react';
import { List, Datagrid, TextField, ReferenceField,
        Edit, SimpleForm, TextInput} from 'react-admin';

export const ListarEndereco = props => (

  <List {...props}>
    <Datagrid>

    <TextField source="id" label="ID"/>
    <ReferenceField source="id" reference="cliente" label="Cliente">
          <TextField source="pnome" label="Nome"/>
    </ReferenceField>
      <TextField source="rua" label="Rua"/>
      <TextField source="numero" label="Numero"/>
      <TextField source="cidade" label="Cidade"/>
      <TextField source="complemento" label="Complemento"/>
    </Datagrid>
  </List>

);

export const EditarEndereco = props => (
  <Edit {...props}>
    <SimpleForm submitOnEnter={true}>
      <TextInput disabled source="id" label="ID"/>
      <TextInput source="rua" label="Rua"/>
      <TextInput source="numero" label="Número"/>
      <TextInput source="cidade" label="Cidade"/>
      <TextInput source="complemento" label="Complemento"/>
    </SimpleForm>

  </Edit>
)