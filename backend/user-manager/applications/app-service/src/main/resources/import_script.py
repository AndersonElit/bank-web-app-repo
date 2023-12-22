'''
create sql-server container
podman run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=@Nd3rs0n' \
  -p 1433:1433 --name sqlservercontainer \
  -d mcr.microsoft.com/mssql/server
'''

'''
create posgresql docker container:
docker run --name user-manager -e POSTGRES_PASSWORD=12345 -d -p 5432:5432 postgres
'''

import pyodbc

server = 'localhost'
database = 'master'
username = 'sa'
password = '@Nd3rs0n'
connection_string = f'DRIVER={{/opt/microsoft/msodbcsql17/lib64/libmsodbcsql-17.10.so.5.1}};SERVER={server};DATABASE={database};UID={username};PWD={password}'

sql_file_path = "/home/anderson-arrieta/Documentos/script_python_comisiones_data/tables.sql"

records = 1000

connection = pyodbc.connect(connection_string)
cursor = connection.cursor()

def populate_test_data():
    try:
        #execute_sql(sql_file_path)
        #clean table
        del_data = "DELETE FROM data_test"
        cursor.execute(del_data)
        sql_query = "INSERT INTO data_test (column1, column2) VALUES ('val1', 'val2')"
        count = 1

        while count <= records:
            cursor.execute(sql_query)
            count += 1
        
        connection.commit()
        print("test table populated.")
    except Exception as e:
        print(f"Error: {str(e)}")
        connection.rollback()

def execute_sql(sql_file_path):
    try:
        with open(sql_file_path, 'r') as file:
            sql_queries = file.read()

        cursor.execute(sql_queries)
        
        connection.commit()
        print("SQL file execution successful.")
    
    except Exception as e:
        print(f"Error: {str(e)}")
        connection.rollback()
    
populate_test_data()
connection.close()
