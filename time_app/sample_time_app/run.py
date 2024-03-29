
from flask import Flask
from datetime import datetime

app = Flask(__name__)


@app.route('/time')
def current_time():
    date = datetime.now()
    return str(date)


@app.route('/')
def hello_world():
    return 'Hello world!'


app.run(host='0.0.0.0',
        port=8080,
        debug=True)
