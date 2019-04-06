#/bin/bash

#-------- nome do responsavel pelo servico ---------
#word0
echo "Responsavel pelo serviço?"
read responsavel

if [ -d "$responsavel" ]
then
	echo "Directory exist"
	cd $responsavel
else
	`mkdir $responsavel`
	echo "Directory created"
	cd $responsavel
fi

#--------- nome do cliente ----------
#word1
echo "Nome do cliente:"
read cliente
if [ -f $cliente.txt ] 
then
	echo "A client with this name already exists"
else 
	cp "../document.txt" $cliente.txt
	echo $responsavel >> answers.txt
	echo $cliente >> answers.txt
	echo "File created successfully!"
fi

#------------- perguntas sobre o produto  ------------------
#word2
echo "Telefone pra contato:"
read entry
echo $entry >> answers.txt
#word3
echo "Modelo do notebook:"
read entry
echo $entry >> answers.txt
#word4
echo "Serviço solicitado:"
read entry
echo $entry >> answers.txt
#word5
echo "Descrição do estado da: Tela, Teclado, Touch-Pad, Som, USB?"
read entry
echo $entry >> answers.txt
#word6
echo possui saida vga e qual o estado?
read entry
echo $entry >> answers.txt
#word7
echo possui saida hdmi e qual o estado?
read entry
echo $entry >> answers.txt
#word8
echo possui leitor de cd e qual o estado?
read entry
echo $entry >> answers.txt
#word9
echo possui porta ethernet e qual o estado?
read entry
echo $entry >> answers.txt

#------------- change reserved words on file  ------------------

file="answers.txt"
count=0

while IFS= read -r line
do
	sed -i 's/word'"${count}"'/'"${line}"'/'  $cliente.txt
	((count += 1))
done <"$file"

rm -f answers.txt

echo "!!Finish service order!!"
