package model;



    /*
    This is Country class, Builder Pattern
    Builder Pattern was implemented by creating an inner class CountryBuilder
    For more information why was used Builder Pattern check README file
     */


public class Country {

    private String id;
    private String name;
    private Continent continent;
    private float surfaceArea;
    private String headOfState;


    //Defining constructor that takes sa an object Builder
    //and initialize all variables with values from inner class
    private Country(BuilderCountry builder){
        this.id = builder.id;
        this.name = builder.name;
        this.continent = builder.continent;
        this.surfaceArea = builder.surfaceArea;
        this.headOfState = builder.headOfState;
    }

    //getters for all variables

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", surfaceArea=" + surfaceArea +
                ", headOfState='" + headOfState + '\'' +
                '}';
    }

    //This is inner class Builder
    public static class BuilderCountry{

        private String id;
        private String name;
        private Continent continent;
        private float surfaceArea;
        private String headOfState;

        //constructor that takes just 3 variables
        //because the surface area and head of state can set as default
        public BuilderCountry(String id, String name, Continent continent){
            this.id = id;
            this.name = name;
            this.continent = continent;


        }

        //Setters for head of state and surface area if will be needed to initialize them
        public BuilderCountry setSutfaceArea (float area){
                this.surfaceArea = area;
                return this;
        }
        public BuilderCountry setHeadOfState(String head){
            this.headOfState = head;
            return this;
        }

        public Country build(){
            return new Country(this);
        }

    }


}
