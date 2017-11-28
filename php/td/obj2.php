<?php

define("BDUSER","root");
define("BDPWD","root");

class baseSql{

    public function save(){
    	echo "insertion en BDD de l'utilisateur ".$this->firstname;
    }
}

class User extends baseSql{

	protected $firstname;
	protected $lastname;
	protected $email;
	protected $pwd;

	public function __construct($firstname=null,$lastname=null,$email=null,$pwd=null){
		$this->setFirstname($firstname);
		$this->setLastname($lastname);
		$this->setEmail($email);
		$this->setPwd($pwd);
//        parent::__construct();
	}

    /**
     * @param mixed $pwd
     *
     * @return self
     */
    public function setPwd($pwd)
    {
    	//appel une méthode de la classe et non de l'objet
        $this->pwd = self::hash($pwd);
        return $this;
    }

    /**
     * @return mixed
     */
    public function getFirstname()
    {
        return $this->firstname;
    }

    /**
     * @param mixed $firstname
     *
     * @return self
     */
    public function setFirstname($firstname)
    {
        $this->firstname = ucfirst(strtolower(trim($firstname)));

        return $this;
    }

    /**
     * @return mixed
     */
    public function getLastname()
    {
        return $this->lastname;
    }

    /**
     * @param mixed $lastname
     *
     * @return self
     */
    public function setLastname($lastname)
    {
        $this->lastname = ucfirst(strtolower(trim($lastname)));

        return $this;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     *
     * @return self
     */
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    public static function hash($string){
    	return password_hash($string, PASSWORD_DEFAULT);
    }
}

//$user = new User();
$user = new User("AIT TIRITE","Soufian","saittirite@myges.fr","test");
print_r($user);

$user->save();