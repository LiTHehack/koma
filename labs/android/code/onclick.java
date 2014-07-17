button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            EditText eText = (EditText)findViewById(R.id.editText1);
            String text = eText.getText().toString();
            if (text.length() > 0) {
                Todo todo = datasource.createTodo(text);
           	    adapter.add(todo);
           	    eText.setText("");
            }
        }
    }
});
