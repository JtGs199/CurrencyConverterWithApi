# CurrencyConverterWithApi
this program uses API from openexchangerates.org to get the latest currency rates

using (java.net.URL) to input the API link and (java.net.HttpURLConnection) to link the program to the website and get information and use (java.io.InputStreamReader)
to read that inforamtion as byte and convert it into characters then using (java.io.BufferedReader) you turn it into a more readable form.

the program will ask the user to input the ammount to be converted, currency to convert,and the currency to be converted to then it'll extract all currency information from the website and look for the rate for these  currencies after that it'll calculate the converted currency and print it to the user

