#
import os
from cryptography.fernet import Fernet
#
files = []
#
for file in os.listdir():
    if file == 'en.py' or file == "thekey.key" or file == "de.py":
        continue
    if os.path.isdir(file):
        files.append(file)
#
print(files)
#
with open("thekey.key", "rb") as key:
    secretkey = key.read()
#
for file in files:
    with open(file, "rb") as thefile:
        contentens = thefile.read()
    contents_decrypted = Fernet(secretkey).decrypt(contentens)
    with open(file, "wb") as thefile:
        thefile.write(contents_decrypted)

