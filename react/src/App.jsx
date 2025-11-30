import { useState, useEffect } from 'react';

import axios from "axios";

import './index.css';

function App() {
    const [imagePath, setImagePath] = useState("waiting");
    const [displayText, setDisplayText] = useState("");
    const [inputText, setInputText] = useState("");


    const BASE_URL = "http://localhost:8080"

    const request = (url, method, data={}) => axios({
        method,
        url: `${BASE_URL}${url}`,
        data
    })

    const client = {
        getInitialText: () => request("/scene", "GET")
            .then((response) => { setDisplayText(response.data); console.log(response.data)}),
        getImage: () => request("/image", "GET")
            .then((response) => { setImagePath(response.data); console.log(response.data)}),
        sendInput: (data) => request("/", "POST", data)
            .then((response) => { setDisplayText(response.data); }),
    };

    // Load initial data when component mounts
    useEffect(() => {
        const loadInitialData = async () => {
            try {
                // Load initial text
                await client.getInitialText();

                // Load initial image
                await client.getImage();
            } catch (error) {
                console.error("Error loading initial data:", error);
            }
        };

        loadInitialData();
    }, []); // Empty dependency array means this runs once on mount

    const handleInputChange = (e) => {
        setInputText(e.target.value);
    };

    const handleSubmit = () => {
        if (inputText.trim()) {
            client.sendInput(inputText)
            setInputText('');
        }
    };

    return (
        <div className="container">
            <div className="wrapper">
                {/* Main Image with Text Overlay */}
                <div className="image-container">
                    <div className="image-wrapper">
                        <img
                            src={`/${imagePath}.png`}
                            alt="Game scene"
                            className="image"
                        />
                    </div>

                    {/* Display Text Bar */}
                    <div className="text-bar">
                        <p className="display-text">
                            {displayText}
                        </p>
                    </div>
                </div>

                {/* Input Text Box with Square Button */}
                <div className="input-container">
                    <div className="input-wrapper">
                        <input
                            type="text"
                            value={inputText}
                            onChange={handleInputChange}
                            placeholder="Type your message..."
                            className="input"
                            onKeyPress={(e) => e.key === 'Enter' && handleSubmit()}
                        />
                        <button
                            onClick={handleSubmit}
                            className="button"
                            aria-label="Submit"
                        >
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                className="icon"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                            >
                                <path
                                    strokeLinecap="round"
                                    strokeLinejoin="round"
                                    strokeWidth={3}
                                    d="M13 7l5 5m0 0l-5 5m5-5H6"
                                />
                            </svg>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;